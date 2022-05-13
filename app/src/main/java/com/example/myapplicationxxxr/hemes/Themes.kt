package com.example.myapplicationxxxr.hemes

import com.example.myapplicationxxxr.R
// настройки темы
class Themes {
    fun menuSet (int: Int): Int  {
        var color = 0
       when(int) {
           1 ->  color = R.color.themes_101
           2 ->  color = R.color.themes_201
           3 ->  color = R.color.themes_301
           4 ->  color = R.color.themes_401
           5 ->  color = R.color.themes_501
           6 ->  color = R.color.themes_601
           7 ->  color = R.color.themes_701
           8 ->  color = R.color.themes_801
           9 ->  color = R.color.themes_901
           10 ->  color = R.color.themes_1001
           else ->  color = R.color.themes_201
       }
        return color
    }

    fun fontSet (int: Int): Int {
        var color = 0
        when(int) {
            1 ->  color = R.color.themes_102
            2 ->  color = R.color.themes_202
            3 ->  color = R.color.themes_302
            4 ->  color = R.color.themes_402
            5 ->  color = R.color.themes_502
            6 ->  color = R.color.themes_602
            7 ->  color = R.color.themes_702
            8 ->  color = R.color.themes_802
            9 ->  color = R.color.themes_902
            10 ->  color = R.color.themes_1002
            else ->  color = R.color.themes_202
        }
        return color
    }

    fun inputSet (int: Int): Int {
        var color = 0
        when(int) {
            1 ->  color = R.color.themes_103
            2 ->  color = R.color.themes_203
            3 ->  color = R.color.themes_303
            4 ->  color = R.color.themes_403
            5 ->  color = R.color.themes_503
            6 ->  color = R.color.themes_603
            7 ->  color = R.color.themes_703
            8 ->  color = R.color.themes_803
            9 ->  color = R.color.themes_903
            10 ->  color = R.color.themes_1003
            else ->  color = R.color.themes_203
        }
        return color
    }

    fun notesSet (int: Int): Int {
        var color = 0
        when(int) {
            1 ->  color = R.color.themes_104
            2 ->  color = R.color.themes_204
            3 ->  color = R.color.themes_304
            4 ->  color = R.color.themes_404
            5 ->  color = R.color.themes_504
            6 ->  color = R.color.themes_604
            7 ->  color = R.color.themes_704
            8 ->  color = R.color.themes_804
            9 ->  color = R.color.themes_904
            10 ->  color = R.color.themes_1004
            else ->  color = R.color.themes_204
        }
        return color
    }

    fun popapSet (int: Int): Int {
        var color = 0
        when(int) {
            1 ->  color = R.color.themes_105
            2 ->  color = R.color.themes_205
            3 ->  color = R.color.themes_305
            4 ->  color = R.color.themes_405
            5 ->  color = R.color.themes_505
            6 ->  color = R.color.themes_605
            7 ->  color = R.color.themes_705
            8 ->  color = R.color.themes_805
            9 ->  color = R.color.themes_905
            10 ->  color = R.color.themes_1005
            else ->  color = R.color.themes_205
        }
        return color
    }

    fun textSet1 (int: Int): Int {
        var color = 0
        when(int) {
            1 ->  color = R.color.themes_106
            2 ->  color = R.color.themes_206
            3 ->  color = R.color.themes_306
            4 ->  color = R.color.themes_406
            5 ->  color = R.color.themes_506
            6 ->  color = R.color.themes_606
            7 ->  color = R.color.themes_706
            8 ->  color = R.color.themes_806
            9 ->  color = R.color.themes_906
            10 ->  color = R.color.themes_1006
            else ->  color = R.color.themes_206
        }
        return color
    }

    fun textSet2 (int: Int): Int {
        var color = 0
        when(int) {
            1 ->  color = R.color.themes_106
            2 ->  color = R.color.themes_207
            3 ->  color = R.color.themes_307
            4 ->  color = R.color.themes_407
            5 ->  color = R.color.themes_507
            6 ->  color = R.color.themes_607
            7 ->  color = R.color.themes_707
            8 ->  color = R.color.themes_807
            9 ->  color = R.color.themes_907
            10 ->  color = R.color.themes_1007
            else ->  color = R.color.themes_207
        }
        return color
    }

    fun shodylSet (int: Int): Int {
        var color = 0
        when(int) {
            1 ->  color = R.color.themes_108
            2 ->  color = R.color.themes_208
            3 ->  color = R.color.themes_308
            4 ->  color = R.color.themes_408
            5 ->  color = R.color.themes_508
            6 ->  color = R.color.themes_608
            7 ->  color = R.color.themes_708
            8 ->  color = R.color.themes_808
            9 ->  color = R.color.themes_908
            10 ->  color = R.color.themes_1008
            else ->  color = R.color.themes_208
        }
        return color
    }
    fun shodylSet1 (int: Int): Int {
        var color = 0
        when(int) {
            1 ->  color = R.drawable.main_button
            2 ->  color = R.drawable.main_button1
            3 ->  color = R.drawable.main_button1
            4 ->  color = R.drawable.main_button
            5 ->  color = R.drawable.main_button
            6 ->  color = R.drawable.main_button1
            7 ->  color = R.drawable.main_button1
            8 ->  color = R.drawable.main_button1
            9 ->  color = R.drawable.main_button
            10 ->  color = R.drawable.main_button
            else -> color = R.drawable.main_button1
        }
        return color
    }
}