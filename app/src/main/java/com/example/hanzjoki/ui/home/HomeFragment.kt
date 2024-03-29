package com.example.hanzjoki.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hanzjoki.databinding.FragmentHomeBinding
import com.example.hanzjoki.R

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: AdapterHome;
    private lateinit var adapter2: PromoAdapter;
    private lateinit var recyclerViewCatagoryList: RecyclerView
    private lateinit var recyclerViewPromoList: RecyclerView

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCatagoryList = root.findViewById(R.id.recyclerView)
        recyclerViewCatagoryList.layoutManager = layoutManager
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.item_margin)

        recyclerViewCatagoryList.addItemDecoration(SpacesItemDecoration(spacingInPixels))

        val categories = ArrayList<CategoryHome>().apply {
            add(CategoryHome("Joki Rank", "star"))
            add(CategoryHome("Joki MCL", "piala"))
            add(CategoryHome("Jasa Mabar", "mabar"))
            add(CategoryHome("Montage", "montage"))
            add(CategoryHome("Joki Classic", "console"))
            // Tambahkan item-category lainnya sesuai kebutuhan
        }
        adapter = AdapterHome(categories)
        recyclerViewCatagoryList.adapter = adapter


        val layoutManager2 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recyclerViewPromoList = root.findViewById(R.id.recyclerView2)
            recyclerViewPromoList.layoutManager = layoutManager2

            val promo = ArrayList<PromoHome>().apply {
                add(PromoHome("Epic", "promoepic"))
                add(PromoHome("Legend", "promolegends"))
                add(PromoHome("Mythic", "promomytic"))
                add(PromoHome("Honor", "promohonor"))
                add(PromoHome("Glory", "promoglory"))
            }


        adapter2 = PromoAdapter(promo)
        recyclerViewPromoList.adapter = adapter2


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
