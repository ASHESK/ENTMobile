package com.example.entmobile.results.s2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.entmobile.R;
import com.example.entmobile.results.RefreshTextView;

import java.text.DecimalFormat;
import java.text.ParseException;

public class S2Fragment extends Fragment {

    private TableLayout tableau_s2;     // Ensemble du tableau du fragment contenant les notes et les matières

    /**
     * Moyennes calculées
     */
    private TextView moyenne_s2;
    private TextView ue21_moyenne;
    private TextView ue22_moyenne;

    /**
     * Noms, coefficients et notes de l'UE21
     */
    private TextView m2101_name;
    private TextView m2101_coef;
    private EditText m2101_ecrit_coef;
    private EditText m2101_tp_coef;
    private TextView m2101_note;
    private EditText m2101_ecrit_note;
    private EditText m2101_tp_note;

    private TextView m2102_name;
    private TextView m2102_coef;
    private EditText m2102_ecrit_coef;
    private EditText m2102_tp_coef;
    private TextView m2102_note;
    private EditText m2102_ecrit_note;
    private EditText m2102_tp_note;

    private TextView m2103_name;
    private TextView m2103_coef;
    private EditText m2103_ecrit_coef;
    private EditText m2103_tp_coef;
    private TextView m2103_note;
    private EditText m2103_ecrit_note;
    private EditText m2103_tp_note;

    private TextView m2104_name;
    private TextView m2104_coef;
    private EditText m2104_ecrit_coef;
    private EditText m2104_tp_coef;
    private TextView m2104_note;
    private EditText m2104_ecrit_note;
    private EditText m2104_tp_note;

    private TextView m2105_name;
    private TextView m2105_coef;
    private EditText m2105_ecrit_coef;
    private EditText m2105_tpprog_coef;
    private EditText m2105_tpspec_coef;
    private TextView m2105_note;
    private EditText m2105_ecrit_note;
    private EditText m2105_tpprog_note;
    private EditText m2105_tpspec_note;

    private TextView m2106_name;
    private TextView m2106_coef;
    private EditText m2106_ecrit_coef;
    private EditText m2106_tp_coef;
    private EditText m2106_xml_coef;
    private TextView m2106_note;
    private EditText m2106_ecrit_note;
    private EditText m2106_tp_note;
    private EditText m2106_xml_note;

    private TextView m2107_name;
    private TextView m2107_coef;
    private EditText m2107_tp_coef;
    private TextView m2107_note;
    private EditText m2107_tp_note;

    /**
     * Noms, coefficients et notes de l'UE22
     */
    private TextView m2201_name;
    private TextView m2201_coef;
    private EditText m2201_ecrit_coef;
    private EditText m2201_tp_coef;
    private TextView m2201_note;
    private EditText m2201_ecrit_note;
    private EditText m2201_tp_note;

    private TextView m2202_name;
    private TextView m2202_coef;
    private EditText m2202_ecrit_coef;
    private EditText m2202_tp_coef;
    private TextView m2202_note;
    private EditText m2202_ecrit_note;
    private EditText m2202_tp_note;

    private TextView m2203_name;
    private TextView m2203_coef;
    private EditText m2203_ecrit_coef;
    private EditText m2203_tp_coef;
    private TextView m2203_note;
    private EditText m2203_ecrit_note;
    private EditText m2203_tp_note;

    private TextView m2204_name;
    private TextView m2204_coef;
    private EditText m2204_ecrit_coef;
    private EditText m2204_tp_coef;
    private TextView m2204_note;
    private EditText m2204_ecrit_note;
    private EditText m2204_tp_note;

    private TextView m2205_name;
    private TextView m2205_coef;
    private EditText m2205_ecrit_coef;
    private EditText m2205_tp_coef;
    private TextView m2205_note;
    private EditText m2205_ecrit_note;
    private EditText m2205_tp_note;

    private TextView m2206_name;
    private TextView m2206_coef;
    private EditText m2206_tp_coef;
    private TextView m2206_note;
    private EditText m2206_tp_note;

    private TextView m2207_name;
    private TextView m2207_coef;
    private EditText m2207_tp_coef;
    private TextView m2207_note;
    private EditText m2207_tp_note;

    private TextView m2208_name;
    private TextView m2208_coef;
    private EditText m2208_tp_coef;
    private TextView m2208_note;
    private EditText m2208_tp_note;

    private RefreshTextView refreshTextView;        // Rafraichit les éléments lorsqu'une note ou un coefficient est rentré

    /**
     * Somme des coefficients des UE
     */
    private float sommecoefue21;
    private float sommecoefue22;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_s2, container, false);
        refreshTextView = new RefreshTextView();

        /**
         * Initialisation des TextView et EditText
         */
        tableau_s2 = root.findViewById(R.id.tableau_s2);

        moyenne_s2 = root.findViewById(R.id.moyenne_s2);
        ue21_moyenne = root.findViewById(R.id.ue21_moyenne);
        ue22_moyenne = root.findViewById(R.id.ue22_moyenne);

        m2101_name = root.findViewById(R.id.m2101_name);
        m2101_coef = root.findViewById(R.id.m2101_coef);
        m2101_ecrit_coef = root.findViewById(R.id.m2101_ecrit_coef);
        m2101_tp_coef = root.findViewById(R.id.m2101_tp_coef);
        m2101_note = root.findViewById(R.id.m2101_note);
        m2101_ecrit_note = root.findViewById(R.id.m2101_ecrit_note);
        m2101_tp_note = root.findViewById(R.id.m2101_tp_note);

        m2102_name = root.findViewById(R.id.m2102_name);
        m2102_coef = root.findViewById(R.id.m2102_coef);
        m2102_ecrit_coef = root.findViewById(R.id.m2102_ecrit_coef);
        m2102_tp_coef = root.findViewById(R.id.m2102_tp_coef);
        m2102_note = root.findViewById(R.id.m2102_note);
        m2102_ecrit_note = root.findViewById(R.id.m2102_ecrit_note);
        m2102_tp_note = root.findViewById(R.id.m2102_tp_note);

        m2103_name = root.findViewById(R.id.m2103_name);
        m2103_coef = root.findViewById(R.id.m2103_coef);
        m2103_ecrit_coef = root.findViewById(R.id.m2103_ecrit_coef);
        m2103_tp_coef = root.findViewById(R.id.m2103_tp_coef);
        m2103_note = root.findViewById(R.id.m2103_note);
        m2103_ecrit_note = root.findViewById(R.id.m2103_ecrit_note);
        m2103_tp_note = root.findViewById(R.id.m2103_tp_note);

        m2104_name = root.findViewById(R.id.m2104_name);
        m2104_coef = root.findViewById(R.id.m2104_coef);
        m2104_ecrit_coef = root.findViewById(R.id.m2104_ecrit_coef);
        m2104_tp_coef = root.findViewById(R.id.m2104_tp_coef);
        m2104_note = root.findViewById(R.id.m2104_note);
        m2104_ecrit_note = root.findViewById(R.id.m2104_ecrit_note);
        m2104_tp_note = root.findViewById(R.id.m2104_tp_note);

        m2105_name = root.findViewById(R.id.m2105_name);
        m2105_coef = root.findViewById(R.id.m2105_coef);
        m2105_ecrit_coef = root.findViewById(R.id.m2105_ecrit_coef);
        m2105_tpprog_coef = root.findViewById(R.id.m2105_tpprog_coef);
        m2105_tpspec_coef = root.findViewById(R.id.m2105_tpspec_coef);
        m2105_note = root.findViewById(R.id.m2105_note);
        m2105_ecrit_note = root.findViewById(R.id.m2105_ecrit_note);
        m2105_tpprog_note = root.findViewById(R.id.m2105_tpprog_note);
        m2105_tpspec_note = root.findViewById(R.id.m2105_tpspec_note);

        m2106_name = root.findViewById(R.id.m2106_name);
        m2106_coef = root.findViewById(R.id.m2106_coef);
        m2106_ecrit_coef = root.findViewById(R.id.m2106_ecrit_coef);
        m2106_tp_coef = root.findViewById(R.id.m2106_tp_coef);
        m2106_xml_coef = root.findViewById(R.id.m2106_xml_coef);
        m2106_note = root.findViewById(R.id.m2106_note);
        m2106_ecrit_note = root.findViewById(R.id.m2106_ecrit_note);
        m2106_tp_note = root.findViewById(R.id.m2106_tp_note);
        m2106_xml_note = root.findViewById(R.id.m2106_xml_note);

        m2107_name = root.findViewById(R.id.m2107_name);
        m2107_coef = root.findViewById(R.id.m2107_coef);
        m2107_tp_coef = root.findViewById(R.id.m2107_tp_coef);
        m2107_note = root.findViewById(R.id.m2107_note);
        m2107_tp_note = root.findViewById(R.id.m2107_tp_note);

        m2201_name = root.findViewById(R.id.m2201_name);
        m2201_coef = root.findViewById(R.id.m2201_coef);
        m2201_ecrit_coef = root.findViewById(R.id.m2201_ecrit_coef);
        m2201_tp_coef = root.findViewById(R.id.m2201_tp_coef);
        m2201_note = root.findViewById(R.id.m2201_note);
        m2201_ecrit_note = root.findViewById(R.id.m2201_ecrit_note);
        m2201_tp_note = root.findViewById(R.id.m2201_tp_note);

        m2202_name = root.findViewById(R.id.m2202_name);
        m2202_coef = root.findViewById(R.id.m2202_coef);
        m2202_ecrit_coef = root.findViewById(R.id.m2202_ecrit_coef);
        m2202_tp_coef = root.findViewById(R.id.m2202_tp_coef);
        m2202_note = root.findViewById(R.id.m2202_note);
        m2202_ecrit_note = root.findViewById(R.id.m2202_ecrit_note);
        m2202_tp_note = root.findViewById(R.id.m2202_tp_note);

        m2203_name = root.findViewById(R.id.m2203_name);
        m2203_coef = root.findViewById(R.id.m2203_coef);
        m2203_ecrit_coef = root.findViewById(R.id.m2203_ecrit_coef);
        m2203_tp_coef = root.findViewById(R.id.m2203_tp_coef);
        m2203_note = root.findViewById(R.id.m2203_note);
        m2203_ecrit_note = root.findViewById(R.id.m2203_ecrit_note);
        m2203_tp_note = root.findViewById(R.id.m2203_tp_note);

        m2204_name = root.findViewById(R.id.m2204_name);
        m2204_coef = root.findViewById(R.id.m2204_coef);
        m2204_ecrit_coef = root.findViewById(R.id.m2204_ecrit_coef);
        m2204_tp_coef = root.findViewById(R.id.m2204_tp_coef);
        m2204_note = root.findViewById(R.id.m2204_note);
        m2204_ecrit_note = root.findViewById(R.id.m2204_ecrit_note);
        m2204_tp_note = root.findViewById(R.id.m2204_tp_note);

        m2205_name = root.findViewById(R.id.m2205_name);
        m2205_coef = root.findViewById(R.id.m2205_coef);
        m2205_ecrit_coef = root.findViewById(R.id.m2205_ecrit_coef);
        m2205_tp_coef = root.findViewById(R.id.m2205_tp_coef);
        m2205_note = root.findViewById(R.id.m2205_note);
        m2205_ecrit_note = root.findViewById(R.id.m2205_ecrit_note);
        m2205_tp_note = root.findViewById(R.id.m2205_tp_note);

        m2206_name = root.findViewById(R.id.m2206_name);
        m2206_coef = root.findViewById(R.id.m2206_coef);
        m2206_tp_coef = root.findViewById(R.id.m2206_tp_coef);
        m2206_note = root.findViewById(R.id.m2206_note);
        m2206_tp_note = root.findViewById(R.id.m2206_tp_note);

        m2207_name = root.findViewById(R.id.m2207_name);
        m2207_coef = root.findViewById(R.id.m2207_coef);
        m2207_tp_coef = root.findViewById(R.id.m2207_tp_coef);
        m2207_note = root.findViewById(R.id.m2207_note);
        m2207_tp_note = root.findViewById(R.id.m2207_tp_note);

        m2208_name = root.findViewById(R.id.m2208_name);
        m2208_coef = root.findViewById(R.id.m2208_coef);
        m2208_tp_coef = root.findViewById(R.id.m2208_tp_coef);
        m2208_note = root.findViewById(R.id.m2208_note);
        m2208_tp_note = root.findViewById(R.id.m2208_tp_note);


        /**
         * Charge les notes et coef de l'UE21 des SharedPreferences et les affiche
         */
        load2CoefFromSharedPreferences(m2101_name, m2101_ecrit_coef, m2101_tp_coef);
        load2GradeFromSharedPreferences(m2101_name, m2101_ecrit_note, m2101_tp_note);
        refreshTextView.refresh2coef2grade(m2101_note, m2101_coef, m2101_ecrit_note, m2101_ecrit_coef, m2101_tp_note, m2101_tp_coef);

        load2CoefFromSharedPreferences(m2102_name, m2102_ecrit_coef, m2102_tp_coef);
        load2GradeFromSharedPreferences(m2102_name, m2102_ecrit_note, m2102_tp_note);
        refreshTextView.refresh2coef2grade(m2102_note, m2102_coef, m2102_ecrit_note, m2102_ecrit_coef, m2102_tp_note, m2102_tp_coef);

        load2CoefFromSharedPreferences(m2103_name, m2103_ecrit_coef, m2103_tp_coef);
        load2GradeFromSharedPreferences(m2103_name, m2103_ecrit_note, m2103_tp_note);
        refreshTextView.refresh2coef2grade(m2103_note, m2103_coef, m2103_ecrit_note, m2103_ecrit_coef, m2103_tp_note, m2103_tp_coef);

        load2CoefFromSharedPreferences(m2104_name, m2104_ecrit_coef, m2104_tp_coef);
        load2GradeFromSharedPreferences(m2104_name, m2104_ecrit_note, m2104_tp_note);
        refreshTextView.refresh2coef2grade(m2104_note, m2104_coef, m2104_ecrit_note, m2104_ecrit_coef, m2104_tp_note, m2104_tp_coef);

        load3CoefFromSharedPreferences(m2105_name, m2105_ecrit_coef, m2105_tpprog_coef, m2105_tpspec_coef);
        load3GradeFromSharedPreferences(m2105_name, m2105_ecrit_note, m2105_tpprog_note, m2105_tpspec_note);
        refreshTextView.refresh3coef3grade(m2105_note, m2105_coef, m2105_ecrit_note, m2105_ecrit_coef, m2105_tpprog_note, m2105_tpprog_coef, m2105_tpspec_note, m2105_tpspec_coef);

        load3CoefFromSharedPreferences(m2106_name, m2106_ecrit_coef, m2106_tp_coef, m2106_xml_coef);
        load3GradeFromSharedPreferences(m2106_name, m2106_ecrit_note, m2106_tp_note, m2106_xml_note);
        refreshTextView.refresh3coef3grade(m2106_note, m2106_coef, m2106_ecrit_note, m2106_ecrit_coef, m2106_tp_note, m2106_tp_coef, m2106_xml_note, m2106_xml_coef);

        loadCoefAndGradeTPFromSharedPreferences(m2107_name, m2107_tp_coef, m2107_tp_note);
        refreshTextView.refresh1coef1grade(m2107_note, m2107_coef, m2107_tp_note, m2107_tp_coef);

        /**
         * Charge les notes et coef de l'UE22 des SharedPreferences et les affiche
         */
        load2CoefFromSharedPreferences(m2201_name, m2201_ecrit_coef, m2201_tp_coef);
        load2GradeFromSharedPreferences(m2201_name, m2201_ecrit_note, m2201_tp_note);
        refreshTextView.refresh2coef2grade(m2201_note, m2201_coef, m2201_ecrit_note, m2201_ecrit_coef, m2201_tp_note, m2201_tp_coef);

        load2CoefFromSharedPreferences(m2202_name, m2202_ecrit_coef, m2202_tp_coef);
        load2GradeFromSharedPreferences(m2202_name, m2202_ecrit_note, m2202_tp_note);
        refreshTextView.refresh2coef2grade(m2202_note, m2202_coef, m2202_ecrit_note, m2202_ecrit_coef, m2202_tp_note, m2202_tp_coef);

        load2CoefFromSharedPreferences(m2203_name, m2203_ecrit_coef, m2203_tp_coef);
        load2GradeFromSharedPreferences(m2203_name, m2203_ecrit_note, m2203_tp_note);
        refreshTextView.refresh2coef2grade(m2203_note, m2203_coef, m2203_ecrit_note, m2203_ecrit_coef, m2203_tp_note, m2203_tp_coef);

        load2CoefFromSharedPreferences(m2204_name, m2204_ecrit_coef, m2204_tp_coef);
        load2GradeFromSharedPreferences(m2204_name, m2204_ecrit_note, m2204_tp_note);
        refreshTextView.refresh2coef2grade(m2204_note, m2204_coef, m2204_ecrit_note, m2204_ecrit_coef, m2204_tp_note, m2204_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m2206_name, m2206_tp_coef, m2206_tp_note);
        refreshTextView.refresh1coef1grade(m2206_note, m2206_coef, m2206_tp_note, m2206_tp_coef);

        load2CoefFromSharedPreferences(m2205_name, m2205_ecrit_coef, m2205_tp_coef);
        load2GradeFromSharedPreferences(m2205_name, m2205_ecrit_note, m2205_tp_note);
        refreshTextView.refresh2coef2grade(m2205_note, m2205_coef, m2205_ecrit_note, m2205_ecrit_coef, m2205_tp_note, m2205_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m2207_name, m2207_tp_coef, m2207_tp_note);
        refreshTextView.refresh1coef1grade(m2207_note, m2207_coef, m2207_tp_note, m2207_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m2208_name, m2208_tp_coef, m2208_tp_note);
        refreshTextView.refresh1coef1grade(m2208_note, m2208_coef, m2208_tp_note, m2208_tp_coef);

        /**
         * Calcul des moyennes
         */
        calculerUE21Moyenne();
        calculerUE22Moyenne();
        calculerMoyenneGenerale();

        /**
         * Listener sur les EditText et TextView pour changer les notes et coef de l'UE21
         */
        m2101_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2101_note, m2101_coef, m2101_ecrit_note, m2101_ecrit_coef, m2101_tp_note, m2101_tp_coef);
                save2CoefInSharedPreferences(m2101_name, m2101_ecrit_coef, m2101_tp_coef);
                save2GradeInSharedPreferences(m2101_name, m2101_ecrit_note, m2101_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2101_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2101_note, m2101_coef, m2101_ecrit_note, m2101_ecrit_coef, m2101_tp_note, m2101_tp_coef);
                save2CoefInSharedPreferences(m2101_name, m2101_ecrit_coef, m2101_tp_coef);
                save2GradeInSharedPreferences(m2101_name, m2101_ecrit_note, m2101_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2101_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2101_note, m2101_coef, m2101_ecrit_note, m2101_ecrit_coef, m2101_tp_note, m2101_tp_coef);
                save2GradeInSharedPreferences(m2101_name, m2101_ecrit_note, m2101_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2101_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2101_note, m2101_coef, m2101_ecrit_note, m2101_ecrit_coef, m2101_tp_note, m2101_tp_coef);
                save2GradeInSharedPreferences(m2101_name, m2101_ecrit_note, m2101_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2102_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2102_note, m2102_coef, m2102_ecrit_note, m2102_ecrit_coef, m2102_tp_note, m2102_tp_coef);
                save2CoefInSharedPreferences(m2102_name, m2102_ecrit_coef, m2102_tp_coef);
                save2GradeInSharedPreferences(m2102_name, m2102_ecrit_note, m2102_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2102_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2102_note, m2102_coef, m2102_ecrit_note, m2102_ecrit_coef, m2102_tp_note, m2102_tp_coef);
                save2CoefInSharedPreferences(m2102_name, m2102_ecrit_coef, m2102_tp_coef);
                save2GradeInSharedPreferences(m2102_name, m2102_ecrit_note, m2102_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2102_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2102_note, m2102_coef, m2102_ecrit_note, m2102_ecrit_coef, m2102_tp_note, m2102_tp_coef);
                save2GradeInSharedPreferences(m2102_name, m2102_ecrit_note, m2102_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2102_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2102_note, m2102_coef, m2102_ecrit_note, m2102_ecrit_coef, m2102_tp_note, m2102_tp_coef);
                save2GradeInSharedPreferences(m2102_name, m2102_ecrit_note, m2102_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2103_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2103_note, m2103_coef, m2103_ecrit_note, m2103_ecrit_coef, m2103_tp_note, m2103_tp_coef);
                save2CoefInSharedPreferences(m2103_name, m2103_ecrit_coef, m2103_tp_coef);
                save2GradeInSharedPreferences(m2103_name, m2103_ecrit_note, m2103_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2103_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2103_note, m2103_coef, m2103_ecrit_note, m2103_ecrit_coef, m2103_tp_note, m2103_tp_coef);
                save2CoefInSharedPreferences(m2103_name, m2103_ecrit_coef, m2103_tp_coef);
                save2GradeInSharedPreferences(m2103_name, m2103_ecrit_note, m2103_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2103_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2103_note, m2103_coef, m2103_ecrit_note, m2103_ecrit_coef, m2103_tp_note, m2103_tp_coef);
                save2GradeInSharedPreferences(m2103_name, m2103_ecrit_note, m2103_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2103_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2103_note, m2103_coef, m2103_ecrit_note, m2103_ecrit_coef, m2103_tp_note, m2103_tp_coef);
                save2GradeInSharedPreferences(m2103_name, m2103_ecrit_note, m2103_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2104_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2104_note, m2104_coef, m2104_ecrit_note, m2104_ecrit_coef, m2104_tp_note, m2104_tp_coef);
                save2CoefInSharedPreferences(m2104_name, m2104_ecrit_coef, m2104_tp_coef);
                save2GradeInSharedPreferences(m2104_name, m2104_ecrit_note, m2104_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2104_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2104_note, m2104_coef, m2104_ecrit_note, m2104_ecrit_coef, m2104_tp_note, m2104_tp_coef);
                save2CoefInSharedPreferences(m2104_name, m2104_ecrit_coef, m2104_tp_coef);
                save2GradeInSharedPreferences(m2104_name, m2104_ecrit_note, m2104_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2104_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2104_note, m2104_coef, m2104_ecrit_note, m2104_ecrit_coef, m2104_tp_note, m2104_tp_coef);
                save2GradeInSharedPreferences(m2104_name, m2104_ecrit_note, m2104_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2104_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2104_note, m2104_coef, m2104_ecrit_note, m2104_ecrit_coef, m2104_tp_note, m2104_tp_coef);
                save2GradeInSharedPreferences(m2104_name, m2104_ecrit_note, m2104_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2105_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2105_note, m2105_coef, m2105_ecrit_note, m2105_ecrit_coef, m2105_tpprog_note, m2105_tpprog_coef, m2105_tpspec_note, m2105_tpspec_coef);
                save3CoefInSharedPreferences(m2105_name, m2105_ecrit_coef, m2105_tpprog_coef, m2105_tpspec_coef);
                save3GradeInSharedPreferences(m2105_name, m2105_ecrit_note, m2105_tpprog_note, m2105_tpspec_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2105_tpprog_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2105_note, m2105_coef, m2105_ecrit_note, m2105_ecrit_coef, m2105_tpprog_note, m2105_tpprog_coef, m2105_tpspec_note, m2105_tpspec_coef);
                save3CoefInSharedPreferences(m2105_name, m2105_ecrit_coef, m2105_tpprog_coef, m2105_tpspec_coef);
                save3GradeInSharedPreferences(m2105_name, m2105_ecrit_note, m2105_tpprog_note, m2105_tpspec_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2105_tpspec_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2105_note, m2105_coef, m2105_ecrit_note, m2105_ecrit_coef, m2105_tpprog_note, m2105_tpprog_coef, m2105_tpspec_note, m2105_tpspec_coef);
                save3CoefInSharedPreferences(m2105_name, m2105_ecrit_coef, m2105_tpprog_coef, m2105_tpspec_coef);
                save3GradeInSharedPreferences(m2105_name, m2105_ecrit_note, m2105_tpprog_note, m2105_tpspec_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2105_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2105_note, m2105_coef, m2105_ecrit_note, m2105_ecrit_coef, m2105_tpprog_note, m2105_tpprog_coef, m2105_tpspec_note, m2105_tpspec_coef);
                save3GradeInSharedPreferences(m2105_name, m2105_ecrit_note, m2105_tpprog_note, m2105_tpspec_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2105_tpprog_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2105_note, m2105_coef, m2105_ecrit_note, m2105_ecrit_coef, m2105_tpprog_note, m2105_tpprog_coef, m2105_tpspec_note, m2105_tpspec_coef);
                save3GradeInSharedPreferences(m2105_name, m2105_ecrit_note, m2105_tpprog_note, m2105_tpspec_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2105_tpspec_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2105_note, m2105_coef, m2105_ecrit_note, m2105_ecrit_coef, m2105_tpprog_note, m2105_tpprog_coef, m2105_tpspec_note, m2105_tpspec_coef);
                save3GradeInSharedPreferences(m2105_name, m2105_ecrit_note, m2105_tpprog_note, m2105_tpspec_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2106_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2106_note, m2106_coef, m2106_ecrit_note, m2106_ecrit_coef, m2106_tp_note, m2106_tp_coef, m2106_xml_note, m2106_xml_coef);
                save3CoefInSharedPreferences(m2106_name, m2106_ecrit_coef, m2106_tp_coef, m2106_xml_coef);
                save3GradeInSharedPreferences(m2106_name, m2106_ecrit_note, m2106_tp_note, m2106_xml_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2106_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2106_note, m2106_coef, m2106_ecrit_note, m2106_ecrit_coef, m2106_tp_note, m2106_tp_coef, m2106_xml_note, m2106_xml_coef);
                save3CoefInSharedPreferences(m2106_name, m2106_ecrit_coef, m2106_tp_coef, m2106_xml_coef);
                save3GradeInSharedPreferences(m2106_name, m2106_ecrit_note, m2106_tp_note, m2106_xml_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2106_xml_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2106_note, m2106_coef, m2106_ecrit_note, m2106_ecrit_coef, m2106_tp_note, m2106_tp_coef, m2106_xml_note, m2106_xml_coef);
                save3CoefInSharedPreferences(m2106_name, m2106_ecrit_coef, m2106_tp_coef, m2106_xml_coef);
                save3GradeInSharedPreferences(m2106_name, m2106_ecrit_note, m2106_tp_note, m2106_xml_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2106_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2106_note, m2106_coef, m2106_ecrit_note, m2106_ecrit_coef, m2106_tp_note, m2106_tp_coef, m2106_xml_note, m2106_xml_coef);
                save3GradeInSharedPreferences(m2106_name, m2106_ecrit_note, m2106_tp_note, m2106_xml_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2106_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2106_note, m2106_coef, m2106_ecrit_note, m2106_ecrit_coef, m2106_tp_note, m2106_tp_coef, m2106_xml_note, m2106_xml_coef);
                save3GradeInSharedPreferences(m2106_name, m2106_ecrit_note, m2106_tp_note, m2106_xml_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2106_xml_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m2106_note, m2106_coef, m2106_ecrit_note, m2106_ecrit_coef, m2106_tp_note, m2106_tp_coef, m2106_xml_note, m2106_xml_coef);
                save3GradeInSharedPreferences(m2106_name, m2106_ecrit_note, m2106_tp_note, m2106_xml_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2107_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m2107_note, m2107_coef, m2107_tp_note, m2107_tp_coef);
                saveCoefGradeTPInSharedPreferences(m2107_name, m2107_tp_coef, m2107_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2107_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m2107_note, m2107_coef, m2107_tp_note, m2107_tp_coef);
                saveCoefGradeTPInSharedPreferences(m2107_name, m2107_tp_coef, m2107_tp_note);
                calculerUE21Moyenne();
                calculerMoyenneGenerale();
            }
        });

        /**
         * Listener sur les EditText et TextView pour changer les notes et coef de l'UE22
         */
        m2201_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2201_note, m2201_coef, m2201_ecrit_note, m2201_ecrit_coef, m2201_tp_note, m2201_tp_coef);
                save2CoefInSharedPreferences(m2201_name, m2201_ecrit_coef, m2201_tp_coef);
                save2GradeInSharedPreferences(m2201_name, m2201_ecrit_note, m2201_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2201_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2201_note, m2201_coef, m2201_ecrit_note, m2201_ecrit_coef, m2201_tp_note, m2201_tp_coef);
                save2CoefInSharedPreferences(m2201_name, m2201_ecrit_coef, m2201_tp_coef);
                save2GradeInSharedPreferences(m2201_name, m2201_ecrit_note, m2201_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2201_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2201_note, m2201_coef, m2201_ecrit_note, m2201_ecrit_coef, m2201_tp_note, m2201_tp_coef);
                save2GradeInSharedPreferences(m2201_name, m2201_ecrit_note, m2201_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2201_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2201_note, m2201_coef, m2201_ecrit_note, m2201_ecrit_coef, m2201_tp_note, m2201_tp_coef);
                save2GradeInSharedPreferences(m2201_name, m2201_ecrit_note, m2201_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2202_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2202_note, m2202_coef, m2202_ecrit_note, m2202_ecrit_coef, m2202_tp_note, m2202_tp_coef);
                save2CoefInSharedPreferences(m2202_name, m2202_ecrit_coef, m2202_tp_coef);
                save2GradeInSharedPreferences(m2202_name, m2202_ecrit_note, m2202_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2202_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2202_note, m2202_coef, m2202_ecrit_note, m2202_ecrit_coef, m2202_tp_note, m2202_tp_coef);
                save2CoefInSharedPreferences(m2202_name, m2202_ecrit_coef, m2202_tp_coef);
                save2GradeInSharedPreferences(m2202_name, m2202_ecrit_note, m2202_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2202_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2202_note, m2202_coef, m2202_ecrit_note, m2202_ecrit_coef, m2202_tp_note, m2202_tp_coef);
                save2GradeInSharedPreferences(m2202_name, m2202_ecrit_note, m2202_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2202_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2202_note, m2202_coef, m2202_ecrit_note, m2202_ecrit_coef, m2202_tp_note, m2202_tp_coef);
                save2GradeInSharedPreferences(m2202_name, m2202_ecrit_note, m2202_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2203_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2203_note, m2203_coef, m2203_ecrit_note, m2203_ecrit_coef, m2203_tp_note, m2203_tp_coef);
                save2CoefInSharedPreferences(m2203_name, m2203_ecrit_coef, m2203_tp_coef);
                save2GradeInSharedPreferences(m2203_name, m2203_ecrit_note, m2203_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2203_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2203_note, m2203_coef, m2203_ecrit_note, m2203_ecrit_coef, m2203_tp_note, m2203_tp_coef);
                save2CoefInSharedPreferences(m2203_name, m2203_ecrit_coef, m2203_tp_coef);
                save2GradeInSharedPreferences(m2203_name, m2203_ecrit_note, m2203_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2203_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2203_note, m2203_coef, m2203_ecrit_note, m2203_ecrit_coef, m2203_tp_note, m2203_tp_coef);
                save2GradeInSharedPreferences(m2203_name, m2203_ecrit_note, m2203_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2203_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2203_note, m2203_coef, m2203_ecrit_note, m2203_ecrit_coef, m2203_tp_note, m2203_tp_coef);
                save2GradeInSharedPreferences(m2203_name, m2203_ecrit_note, m2203_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2204_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2204_note, m2204_coef, m2204_ecrit_note, m2204_ecrit_coef, m2204_tp_note, m2204_tp_coef);
                save2CoefInSharedPreferences(m2204_name, m2204_ecrit_coef, m2204_tp_coef);
                save2GradeInSharedPreferences(m2204_name, m2204_ecrit_note, m2204_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2204_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2204_note, m2204_coef, m2204_ecrit_note, m2204_ecrit_coef, m2204_tp_note, m2204_tp_coef);
                save2CoefInSharedPreferences(m2204_name, m2204_ecrit_coef, m2204_tp_coef);
                save2GradeInSharedPreferences(m2204_name, m2204_ecrit_note, m2204_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2204_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2204_note, m2204_coef, m2204_ecrit_note, m2204_ecrit_coef, m2204_tp_note, m2204_tp_coef);
                save2GradeInSharedPreferences(m2204_name, m2204_ecrit_note, m2204_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2204_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2204_note, m2204_coef, m2204_ecrit_note, m2204_ecrit_coef, m2204_tp_note, m2204_tp_coef);
                save2GradeInSharedPreferences(m2204_name, m2204_ecrit_note, m2204_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2206_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m2206_note, m2206_coef, m2206_tp_note, m2206_tp_coef);
                saveCoefGradeTPInSharedPreferences(m2206_name, m2206_tp_coef, m2206_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2206_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m2206_note, m2206_coef, m2206_tp_note, m2206_tp_coef);
                saveCoefGradeTPInSharedPreferences(m2206_name, m2206_tp_coef, m2206_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2205_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2205_note, m2205_coef, m2205_ecrit_note, m2205_ecrit_coef, m2205_tp_note, m2205_tp_coef);
                save2CoefInSharedPreferences(m2205_name, m2205_ecrit_coef, m2205_tp_coef);
                save2GradeInSharedPreferences(m2205_name, m2205_ecrit_note, m2205_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2205_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2205_note, m2205_coef, m2205_ecrit_note, m2205_ecrit_coef, m2205_tp_note, m2205_tp_coef);
                save2CoefInSharedPreferences(m2205_name, m2205_ecrit_coef, m2205_tp_coef);
                save2GradeInSharedPreferences(m2205_name, m2205_ecrit_note, m2205_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2205_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2205_note, m2205_coef, m2205_ecrit_note, m2205_ecrit_coef, m2205_tp_note, m2205_tp_coef);
                save2GradeInSharedPreferences(m2205_name, m2205_ecrit_note, m2205_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2205_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m2205_note, m2205_coef, m2205_ecrit_note, m2205_ecrit_coef, m2205_tp_note, m2205_tp_coef);
                save2GradeInSharedPreferences(m2205_name, m2205_ecrit_note, m2205_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2207_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m2207_note, m2207_coef, m2207_tp_note, m2207_tp_coef);
                saveCoefGradeTPInSharedPreferences(m2207_name, m2207_tp_coef, m2207_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2207_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m2207_note, m2207_coef, m2207_tp_note, m2207_tp_coef);
                saveCoefGradeTPInSharedPreferences(m2207_name, m2207_tp_coef, m2207_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m2208_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m2208_note, m2208_coef, m2208_tp_note, m2208_tp_coef);
                saveCoefGradeTPInSharedPreferences(m2208_name, m2208_tp_coef, m2208_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m2208_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m2208_note, m2208_coef, m2208_tp_note, m2208_tp_coef);
                saveCoefGradeTPInSharedPreferences(m2208_name, m2208_tp_coef, m2208_tp_note);
                calculerUE22Moyenne();
                calculerMoyenneGenerale();
            }
        });

        return root;
    }

    /**
     * Calcul de la moyenne de l'UE21
     */
    public void calculerUE21Moyenne() {
        sommecoefue21 = 0;
        float ue21 = 0;

        for (int i = 0; i < tableau_s2.getChildCount(); i++) {
            TextView coef = tableau_s2.getChildAt(i).findViewWithTag("coef1");
            TextView note = tableau_s2.getChildAt(i).findViewWithTag("note1");
            if (coef == null || note == null) continue;
            DecimalFormat decimalFormat = new DecimalFormat();
            try {
                float coefvalue = decimalFormat.parse(coef.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                float notevalue = decimalFormat.parse(note.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                ue21 += coefvalue * notevalue;
                sommecoefue21 += coefvalue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ue21_moyenne.setText(" " + Math.floor((ue21/sommecoefue21)*100)/100);
    }

    /**
     * Calcul de la moyenne de l'UE22
     */
    public void calculerUE22Moyenne() {
        sommecoefue22 = 0;
        float ue22 = 0;

        for (int i = 0; i < tableau_s2.getChildCount(); i++) {
            TextView coef = tableau_s2.getChildAt(i).findViewWithTag("coef2");
            TextView note = tableau_s2.getChildAt(i).findViewWithTag("note2");
            if (coef == null || note == null) continue;
            DecimalFormat decimalFormat = new DecimalFormat();
            try {
                float coefvalue = decimalFormat.parse(coef.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                float notevalue = decimalFormat.parse(note.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                ue22 += coefvalue * notevalue;
                sommecoefue22 += coefvalue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ue22_moyenne.setText(" " + Math.floor((ue22/sommecoefue22)*100)/100);
    }

    /**
     * Calcul de la moyenne générale
     */
    public void calculerMoyenneGenerale() {
        float sommeTotalCoef = sommecoefue21 + sommecoefue22;
        float s2 = (Float.parseFloat(ue21_moyenne.getText().toString()) * sommecoefue21) + (Float.parseFloat(ue22_moyenne.getText().toString()) * sommecoefue22);

        moyenne_s2.setText(" " + Math.floor((s2/sommeTotalCoef)*100)/100);
    }

    /**
     * Sauvegarde le coefficient et la note TP d'une matiere lorsqu'elle n'a qu'une note TP
     * @param nom_matiere le nom de la matiere
     * @param coef_tp le coefficient TP de la matière
     * @param note_tp la note TP de la matiere
     */
    public void saveCoefGradeTPInSharedPreferences(TextView nom_matiere, EditText coef_tp, EditText note_tp) {
        //Initializes the SharedPreferences and initializes the SharedPreferences' editor
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(nom_matiere.getText().toString() + "coef_tp", coef_tp.getText().toString());
        editor.putString(nom_matiere.getText().toString() + "note_tp", note_tp.getText().toString());

        editor.apply();
    }

    /**
     * Sauvegarde le coefficient des notes Ecrit et TP d'une matiere
     * @param nom_matiere le nom de la matiere
     * @param coef_ecrit le coefficient de la note ecrite
     * @param coef_tp le coefficient de la note TP
     */
    public void save2CoefInSharedPreferences(TextView nom_matiere, EditText coef_ecrit, EditText coef_tp) {
        //Initializes the SharedPreferences and initializes the SharedPreferences' editor
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(nom_matiere.getText().toString() + "coef_ecrit", coef_ecrit.getText().toString());
        editor.putString(nom_matiere.getText().toString() + "coef_tp", coef_tp.getText().toString());

        editor.apply();
    }

    /**
     * Sauvegarde les notes Ecrit et TP d'une matiere
     * @param nom_matiere le nom de la matiere
     * @param note_ecrite la note Ecrit
     * @param note_tp la note TP
     */
    public void save2GradeInSharedPreferences(TextView nom_matiere, EditText note_ecrite, EditText note_tp) {
        //Initializes the SharedPreferences and initializes the SharedPreferences' editor
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(nom_matiere.getText().toString() + "note_ecrite", note_ecrite.getText().toString());
        editor.putString(nom_matiere.getText().toString() + "note_tp", note_tp.getText().toString());

        editor.apply();
    }

    /**
     * Sauvegarde 3 coefficients d'une matiere lorsqu'elle en a 3
     * @param nom_matiere le nom de la matiere
     * @param coef1 le premier coefficient
     * @param coef2 le deuxieme coefficient
     * @param coef3 le troisieme coefficient
     */
    public void save3CoefInSharedPreferences(TextView nom_matiere, EditText coef1, EditText coef2, EditText coef3) {
        //Initializes the SharedPreferences and initializes the SharedPreferences' editor
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(nom_matiere.getText().toString() + "coef1", coef1.getText().toString());
        editor.putString(nom_matiere.getText().toString() + "coef2", coef2.getText().toString());
        editor.putString(nom_matiere.getText().toString() + "coef3", coef3.getText().toString());

        editor.apply();
    }

    /**
     * Sauvegarde 3 notes d'une matiere lorsqu'elle en a 3
     * @param nom_matiere le nom de la matiere
     * @param note1 la premiere note
     * @param note2 la deuxieme note
     * @param note3 la troisieme note
     */
    public void save3GradeInSharedPreferences(TextView nom_matiere, EditText note1, EditText note2, EditText note3) {
        //Initializes the SharedPreferences and initializes the SharedPreferences' editor
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(nom_matiere.getText().toString() + "note1", note1.getText().toString());
        editor.putString(nom_matiere.getText().toString() + "note2", note2.getText().toString());
        editor.putString(nom_matiere.getText().toString() + "note3", note3.getText().toString());

        editor.apply();
    }

    /**
     * Charge les coefficients des notes TP et Ecrit
     * @param nom_matiere le nom de la matiere
     * @param coef_ecrit le coefficient Ecrit
     * @param coef_tp le coefficient TP
     */
    public void load2CoefFromSharedPreferences(TextView nom_matiere, EditText coef_ecrit, EditText coef_tp) {
        //Initializes the SharedPreferences
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE); //Initializes the SharedPreferences

        //Retrieves each of the Note's attributes from the SharedPreferences
        String ecrit_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "coef_ecrit", ""); //Gets the amount of notes saved in the SharedPreferences
        String tp_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "coef_tp", ""); //Gets the amount of notes saved in the SharedPreferences

        coef_ecrit.setText(ecrit_shared_preferences);
        coef_tp.setText(tp_shared_preferences);
    }

    /**
     * Charge les notes TP et Ecrit
     * @param nom_matiere le nom de la matiere
     * @param note_ecrite la note Ecrit
     * @param note_tp la note TP
     */
    public void load2GradeFromSharedPreferences(TextView nom_matiere, EditText note_ecrite, EditText note_tp) {
        //Initializes the SharedPreferences
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE); //Initializes the SharedPreferences

        //Retrieves each of the Note's attributes from the SharedPreferences
        String ecrit_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "note_ecrite", ""); //Gets the amount of notes saved in the SharedPreferences
        String tp_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "note_tp", ""); //Gets the amount of notes saved in the SharedPreferences

        note_ecrite.setText(ecrit_shared_preferences);
        note_tp.setText(tp_shared_preferences);
    }

    /**
     * Charge la note et le coefficient TP d'une matiere
     * @param nom_matiere le nom de la matiere
     * @param coef_tp le coefficient TP
     * @param note_tp la note TP
     */
    public void loadCoefAndGradeTPFromSharedPreferences(TextView nom_matiere, EditText coef_tp, EditText note_tp) {
        //Initializes the SharedPreferences
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE); //Initializes the SharedPreferences

        //Retrieves each of the Note's attributes from the SharedPreferences
        String ecrit_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "coef_tp", ""); //Gets the amount of notes saved in the SharedPreferences
        String tp_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "note_tp", ""); //Gets the amount of notes saved in the SharedPreferences

        coef_tp.setText(ecrit_shared_preferences);
        note_tp.setText(tp_shared_preferences);
    }

    /**
     * Charge les 3 coefficients d'une matiere
     * @param nom_matiere le nom de la matiere
     * @param coef1 le premier coefficient
     * @param coef2 le deuxieme coefficient
     * @param coef3 le troisieme coefficient
     */
    public void load3CoefFromSharedPreferences(TextView nom_matiere, EditText coef1, EditText coef2, EditText coef3) {
        //Initializes the SharedPreferences
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE); //Initializes the SharedPreferences

        //Retrieves each of the Note's attributes from the SharedPreferences
        String coef1_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "coef1", ""); //Gets the amount of notes saved in the SharedPreferences
        String coef2_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "coef2", ""); //Gets the amount of notes saved in the SharedPreferences
        String coef3_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "coef3", ""); //Gets the amount of notes saved in the SharedPreferences

        coef1.setText(coef1_shared_preferences);
        coef2.setText(coef2_shared_preferences);
        coef3.setText(coef3_shared_preferences);
    }

    /**
     * Charge les 3 notes d'une matiere
     * @param nom_matiere le nom de la matiere
     * @param note1 la premiere note
     * @param note2 la deuxieme note
     * @param note3 la troisieme note
     */
    public void load3GradeFromSharedPreferences(TextView nom_matiere, EditText note1, EditText note2, EditText note3) {
        //Initializes the SharedPreferences
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE); //Initializes the SharedPreferences

        //Retrieves each of the Note's attributes from the SharedPreferences
        String note1_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "note1", ""); //Gets the amount of notes saved in the SharedPreferences
        String note2_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "note2", ""); //Gets the amount of notes saved in the SharedPreferences
        String note3_shared_preferences = preferences.getString(nom_matiere.getText().toString() + "note3", ""); //Gets the amount of notes saved in the SharedPreferences

        note1.setText(note1_shared_preferences);
        note2.setText(note2_shared_preferences);
        note3.setText(note3_shared_preferences);
    }
}