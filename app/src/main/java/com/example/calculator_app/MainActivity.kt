package com.example.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.calculator_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.num0.setOnClickListener{v->
            binding.panel.setText("0").toString()
        }

        binding.num1.setOnClickListener { v->
            binding.panel.setText("1").toString()
        }

        binding.num2.setOnClickListener { v->
            binding.panel.setText("2").toString()
        }

        binding.num3.setOnClickListener { v->
            binding.panel.setText("3").toString()
        }

        binding.num4.setOnClickListener { v->
            binding.panel.setText("4").toString()
        }
        binding.num5.setOnClickListener { v->
            binding.panel.setText("5").toString()
        }
        binding.num6.setOnClickListener { v->
            binding.panel.setText("6").toString()
        }
        binding.num7.setOnClickListener { v->
            binding.panel.setText("7").toString()
        }
        binding.num8.setOnClickListener { v->
            binding.panel.setText("8").toString()
        }
        binding.num9.setOnClickListener { v->
            binding.panel.setText("9").toString()
        }
        binding.uparrow.setOnClickListener { v->
            binding.panel.setText("^").toString()
        }
        binding.division.setOnClickListener { v->
            binding.panel.setText("/").toString()
        }
        binding.multiply.setOnClickListener { v->
            binding.panel.setText("*").toString()
        }
        binding.clearbutton.setOnClickListener { v->
            binding.panel.setText("").toString()
        }
        binding.cancelbutton.setOnClickListener { v->
            binding.panel.setText("XX").toString()
        }
        binding.subtract.setOnClickListener { v->
            binding.panel.setText("-").toString()
        }
        binding.add.setOnClickListener { v->
            binding.panel.setText("+").toString()
        }
        binding.equal.setOnClickListener {v->
            binding.panel.setText("=").toString()
        }
        binding.modulo.setOnClickListener { v->
            binding.panel.setText("%").toString()
        }
        binding.point.setOnClickListener { v->
            binding.panel.setText(".").toString()
        }
    }
}