package id.neotica.rickpositorylegacy.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import id.neotica.rickpositorylegacy.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MainFragmentViewModel viewModel;

    private FragmentMainBinding binding;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentMainBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (viewModelFactory == null) {
            Log.e("MainFragment", "ViewModelFactory is NULL in onViewCreated. Dagger injection failed.");
            // This indicates a deeper Dagger setup issue if onAttach was called with AndroidSupportInjection.inject(this)
            // and DaggerAppComponent is generating correctly.
            return;
        }
        viewModel = new ViewModelProvider(this, viewModelFactory).get(MainFragmentViewModel.class);

        viewModel.characters.observe(getViewLifecycleOwner(), charactersModel -> {
            Log.d("MainFragment", "Characters loaded: " + (charactersModel != null ? "Data received" : "Null data"));
            // Update your UI
        });

        viewModel.error.observe(getViewLifecycleOwner(), errorMsg -> {
            Log.e("MainFragment", "Error: " + errorMsg);
            // Display error
        });

        viewModel.loadCharacters();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}