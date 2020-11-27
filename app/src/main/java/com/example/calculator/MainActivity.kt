package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var operation : Boolean = false
    var dotexist : Boolean = false
    var signexist : Boolean = false
    var zeros : Boolean = false
    var numexistance = false
    var firstvalue : Double = 0.0
    var secondvalue : Double = 0.0
    var signtag : Int = 0
    var textstring : String = ""
    fun onclick(view: View) {
        var screen = findViewById<TextView>(R.id.textView)
        var inputtag = view.tag.toString().toInt()
            if (inputtag in 0..9) {
                when (zeros) {
                    false -> {
                        if (inputtag in 1..9) {
                            textstring = inputtag.toString()
                            screen.text = textstring
                            numexistance = true
                            zeros = true
                            secondvalue = textstring.toDouble()
                        }
                    }
                    true -> {
                        if (inputtag in 0..9) {
                            secondvalue = 0.0
                            textstring += inputtag.toString()
                            screen.text = textstring
                            numexistance = true
                            secondvalue = textstring.toDouble()
                        }
                    }
                }
                if(firstvalue!=0.0 &&secondvalue != 0.0){operation = true}
            }
            else if (inputtag in 11..14 && numexistance == true && operation == false) {
                if (signexist == true) {
                    when (inputtag) {
                        11 -> {
                            screen.text = "+";
                        }
                        12 -> {
                            screen.text = "-";
                        }
                        13 -> {
                            screen.text = "/";
                        }
                        14 -> {
                            screen.text = "*";
                        }
                    }
                    signtag = inputtag;
                } else if (signexist == false) {
                    when (inputtag) {
                        11 -> {
                            screen.text = "+";
                        }
                        12 -> {
                            screen.text = "-";
                        }
                        13 -> {
                            screen.text = "/";
                        }
                        14 -> {
                            screen.text = "*";
                        }
                    }
                    dotexist = false;
                    signtag = inputtag;
                    signexist = true
                    zeros = false;
                    firstvalue = secondvalue;
                    secondvalue = 0.0
                }
            } else if (inputtag == 19 && dotexist == false) {
                if (secondvalue != 0.0) {
                    textstring += "."
                    screen.text = textstring
                    dotexist = true
                    zeros = true
                } else if (secondvalue == 0.0) {
                    textstring = "0."
                    screen.text = textstring
                    dotexist = true
                    zeros = true
                }
            } else if (inputtag == 15) {
                dotexist = false
                signexist = false
                zeros = false
                numexistance = false
                firstvalue = 0.0
                secondvalue = 0.0
                signtag = 0
                textstring = ""
                screen.text = textstring
            } else if (inputtag == 10 && operation == true) { //10
                when (signtag) {
                    11 -> {
                        secondvalue = firstvalue + secondvalue; }
                    12 -> {
                        secondvalue = firstvalue - secondvalue; }
                    13 -> {
                        secondvalue = firstvalue / secondvalue; }
                    14 -> {
                        secondvalue = firstvalue * secondvalue; }
                }
                textstring = secondvalue.toString()
                screen.text = textstring
                numexistance = true
                zeros = true
                signexist = false
                operation = false
                firstvalue = 0.0
            }
            else if(inputtag in 16..18 && secondvalue != 0.0 && firstvalue ==0.0 ){
                when(inputtag) {
                    16 -> {
                        secondvalue = secondvalue * (-1);screen.text = secondvalue.toString()
                    }
                    17 -> {
                        secondvalue *= secondvalue;screen.text = secondvalue.toString()
                    }
                    18 -> {
                        secondvalue /= 100 ; screen.text = secondvalue.toString()
                    }
                }
            }

        }

    }



