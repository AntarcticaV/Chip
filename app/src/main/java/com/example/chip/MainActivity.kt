package com.example.chip
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {
    private var chipAction: Chip? = null
    private var chipChoice: Chip? = null
    private var chipEntry: Chip? = null
    private var chipFilter: Chip? = null
    private var chipCustom: Chip? = null
    private var editTextLog: EditText? = null
    private var buttonClear: Button? = null
    private var clickListener: View.OnClickListener? = null
    private var closeIconClickListener: View.OnClickListener? = null
    private var checkedChangeListener: CompoundButton.OnCheckedChangeListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chipAction = findViewById<View>(R.id.chip_action) as Chip
        chipChoice = findViewById<View>(R.id.chip_choice) as Chip
        chipEntry = findViewById<View>(R.id.chip_entry) as Chip
        chipFilter = findViewById<View>(R.id.chip_filter) as Chip
        chipCustom = findViewById<View>(R.id.chip_custom) as Chip
        editTextLog = findViewById<View>(R.id.editText_log) as EditText
        buttonClear = findViewById<View>(R.id.button_clear) as Button

        //
        clickListener = ClickListenerImpl()
        closeIconClickListener = CloseIconClickListenerImpl()
        checkedChangeListener = CheckedChangeListenerImpl()

        //
        chipAction!!.setOnClickListener(clickListener)
        chipAction!!.setOnCloseIconClickListener(closeIconClickListener)
        chipAction!!.setOnCheckedChangeListener(checkedChangeListener)
        //
        chipChoice!!.setOnClickListener(clickListener)
        chipChoice!!.setOnCloseIconClickListener(closeIconClickListener)
        chipChoice!!.setOnCheckedChangeListener(checkedChangeListener)
        //
        chipEntry!!.setOnClickListener(clickListener)
        chipEntry!!.setOnCloseIconClickListener(closeIconClickListener)
        chipEntry!!.setOnCheckedChangeListener(checkedChangeListener)
        //
        chipFilter!!.setOnClickListener(clickListener)
        chipFilter!!.setOnCloseIconClickListener(closeIconClickListener)
        chipFilter!!.setOnCheckedChangeListener(checkedChangeListener)
        //
        chipCustom!!.setOnClickListener(clickListener)
        chipCustom!!.setOnCloseIconClickListener(closeIconClickListener)
        chipCustom!!.setOnCheckedChangeListener(checkedChangeListener)
        //
        buttonClear!!.setOnClickListener { editTextLog!!.setText("") }
    }

    private fun appendLog(text: String) {
        editTextLog!!.append(text)
        editTextLog!!.append("\n")
        Log.i(LOG_TAG, text)
    }

    internal inner class ClickListenerImpl : View.OnClickListener {
        override fun onClick(v: View) {
            appendLog("Clicked")
        }
    }

    internal inner class CloseIconClickListenerImpl : View.OnClickListener {
        override fun onClick(v: View) {
            appendLog("Close Icon Clicked")
        }
    }

    internal inner class CheckedChangeListenerImpl : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
            appendLog("Checked Changed! isChecked? $isChecked")
        }
    }

    companion object {
        private const val LOG_TAG = "AndroidChipDemo"
    }
}