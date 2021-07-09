package ru.axas.avatars.presentation.entrance_ui.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.ToggleButton
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.viewModels
import com.google.android.material.button.MaterialButtonToggleGroup
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import ru.axas.avatars.R
import ru.axas.avatars.databinding.FragmentAuthorizationBinding
import ru.axas.avatars.presentation.BaseFragment
import ru.axas.avatars.presentation.ENTRANCE
import ru.axas.avatars.presentation.activities.BaseActivity
import ru.axas.avatars.presentation.entrance_ui.view_models.AuthorizViewModel
@AndroidEntryPoint
class AuthorizationFragment : BaseFragment() , CompoundButton.OnCheckedChangeListener {
    override val TAG_LOG: String = ENTRANCE
    val viewModel : AuthorizViewModel by viewModels()

    val checkOff by lazy{ AppCompatResources.getDrawable(requireContext(),R.drawable.check_off)?.apply {
        setBounds(0, 0, 75, 75) }}
    val checkOn  by lazy{AppCompatResources.getDrawable(requireContext(),R.drawable.check_on)?.apply {
        setBounds(0, 0, 75, 75) }}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAuthorizationBinding.inflate(inflater)

        binding.toggle01.init()
        binding.toggle02.init()



        return binding.root
    }
    fun ToggleButton.init(){
        changeDrawable(false);
        setOnCheckedChangeListener(this@AuthorizationFragment)
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        buttonView?.changeDrawable(isChecked)
    }

    fun Button.changeDrawable(isChecked: Boolean){
        if (isChecked){
            this.setCompoundDrawables(checkOn,null,null,null)
        }else{
            this.setCompoundDrawables(checkOff,null,null,null)}
    }
}