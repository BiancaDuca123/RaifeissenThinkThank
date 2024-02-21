package com.ubb.raiffaisen.thinktank.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ubb.raiffaisen.thinktank.databinding.BottomSheetBinding

class CreateCategoryBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addCategoryBtn.setOnClickListener {
            dismiss()
        }
    }
}