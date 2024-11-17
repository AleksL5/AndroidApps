package com.example.mapapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mapapp.databinding.FragmentMapBinding
import org.osmdroid.api.IMapController
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import androidx.fragment.app.viewModels
import org.osmdroid.views.overlay.Marker

class MapFragment : Fragment() {

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MapViewModel by viewModels()
    private lateinit var mapView: MapView
    private lateinit var mapController: IMapController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView = binding.mapView
        mapView.setMultiTouchControls(true)
        mapController = mapView.controller


        val startPoint = GeoPoint(48.8584, 2.2945)
        var mapCenter = startPoint

        mapController.setZoom(12.0)
        mapController.setCenter(startPoint)

        savedInstanceState?.let {
            mapCenter = it.getParcelable("map_center") ?: startPoint
            val mapZoom = it.getDouble("map_zoom", 12.0)
            mapController.setCenter(mapCenter)
            mapController.setZoom(mapZoom)
        }

        viewModel.loadLandmarks(mapCenter.latitude, mapCenter.longitude)


        viewModel.landmarks.observe(viewLifecycleOwner) { landmarks ->
            mapView.overlays.clear()
            landmarks.forEach { landmark ->
                val marker = Marker(mapView)
                marker.position = GeoPoint(landmark.latitude, landmark.longitude)
                marker.title = landmark.name
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                marker.setOnMarkerClickListener { _, _ ->
                    Toast.makeText(requireContext(), landmark.name, Toast.LENGTH_SHORT).show()
                    true
                }
                mapView.overlays.add(marker)
            }
        }


        viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val mapCenter = GeoPoint(mapView.mapCenter.latitude, mapView.mapCenter.longitude)
        val mapZoom = mapView.zoomLevelDouble

        outState.putParcelable("map_center", mapCenter)
        outState.putDouble("map_zoom", mapZoom)
    }
    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}