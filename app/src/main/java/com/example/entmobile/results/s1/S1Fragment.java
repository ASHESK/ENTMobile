package com.example.entmobile.results.s1;

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

public class S1Fragment extends Fragment {

    private TableLayout tableau_s1;     // Ensemble du tableau du fragment contenant les notes et les matières

    /**
     * Moyennes calculées
     */
    private TextView moyenne_s1;
    private TextView ue11_moyenne;
    private TextView ue12_moyenne;

    /**
     * Noms, coefficients et notes de l'UE11
     */
    private TextView m1101_name;
    private TextView m1101_coef;
    private EditText m1101_ecrit_coef;
    private EditText m1101_tp_coef;
    private TextView m1101_note;
    private EditText m1101_ecrit_note;
    private EditText m1101_tp_note;

    private TextView m1102_name;
    private TextView m1102_coef;
    private EditText m1102_ecrit_coef;
    private EditText m1102_tp_coef;
    private TextView m1102_note;
    private EditText m1102_ecrit_note;
    private EditText m1102_tp_note;

    private TextView m1103_name;
    private TextView m1103_coef;
    private EditText m1103_ecrit_coef;
    private EditText m1103_tp_coef;
    private TextView m1103_note;
    private EditText m1103_ecrit_note;
    private EditText m1103_tp_note;

    private TextView m1104_name;
    private TextView m1104_coef;
    private EditText m1104_ecrit_coef;
    private EditText m1104_tp_coef;
    private TextView m1104_note;
    private EditText m1104_ecrit_note;
    private EditText m1104_tp_note;

    private TextView m1105_name;
    private TextView m1105_coef;
    private EditText m1105_webtp_coef;
    private EditText m1105_comecrit_coef;
    private EditText m1105_comtp_coef;
    private TextView m1105_note;
    private EditText m1105_webtp_note;
    private EditText m1105_comecrit_note;
    private EditText m1105_comtp_note;

    private TextView m1106_name;
    private TextView m1106_coef;
    private EditText m1106_tp_coef;
    private TextView m1106_note;
    private EditText m1106_tp_note;


    /**
     * Noms, coefficients et notes de l'UE12
     */
    private TextView m1201_name;
    private TextView m1201_coef;
    private EditText m1201_ecrit_coef;
    private EditText m1201_tp_coef;
    private TextView m1201_note;
    private EditText m1201_ecrit_note;
    private EditText m1201_tp_note;

    private TextView m1202_name;
    private TextView m1202_coef;
    private EditText m1202_ecrit_coef;
    private EditText m1202_tp_coef;
    private TextView m1202_note;
    private EditText m1202_ecrit_note;
    private EditText m1202_tp_note;

    private TextView m1203_name;
    private TextView m1203_coef;
    private EditText m1203_ecrit_coef;
    private EditText m1203_tp_coef;
    private TextView m1203_note;
    private EditText m1203_ecrit_note;
    private EditText m1203_tp_note;

    private TextView m1204_name;
    private TextView m1204_coef;
    private EditText m1204_ecrit_coef;
    private EditText m1204_tp_coef;
    private TextView m1204_note;
    private EditText m1204_ecrit_note;
    private EditText m1204_tp_note;

    private TextView m1205_name;
    private TextView m1205_coef;
    private EditText m1205_tp_coef;
    private TextView m1205_note;
    private EditText m1205_tp_note;

    private TextView m1206_name;
    private TextView m1206_coef;
    private EditText m1206_ecrit_coef;
    private EditText m1206_tp_coef;
    private TextView m1206_note;
    private EditText m1206_ecrit_note;
    private EditText m1206_tp_note;

    private TextView m1207_name;
    private TextView m1207_coef;
    private EditText m1207_tp_coef;
    private TextView m1207_note;
    private EditText m1207_tp_note;

    private RefreshTextView refreshTextView;        // Rafraichit les éléments lorsqu'une note ou un coefficient est rentré

    /**
     * Somme des coefficients des UE
     */
    private float sommecoefue11;
    private float sommecoefue12;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_s1, container, false);
        refreshTextView = new RefreshTextView();

        /**
         * Initialisation des TextView et EditText
         */
        tableau_s1 = root.findViewById(R.id.tableau_s1);

        moyenne_s1 = root.findViewById(R.id.moyenne_s1);
        ue11_moyenne = root.findViewById(R.id.ue11_moyenne);
        ue12_moyenne = root.findViewById(R.id.ue12_moyenne);

        m1101_name = root.findViewById(R.id.m1101_name);
        m1101_coef = root.findViewById(R.id.m1101_coef);
        m1101_ecrit_coef = root.findViewById(R.id.m1101_ecrit_coef);
        m1101_tp_coef = root.findViewById(R.id.m1101_tp_coef);
        m1101_note = root.findViewById(R.id.m1101_note);
        m1101_ecrit_note = root.findViewById(R.id.m1101_ecrit_note);
        m1101_tp_note = root.findViewById(R.id.m1101_tp_note);

        m1102_name = root.findViewById(R.id.m1102_name);
        m1102_coef = root.findViewById(R.id.m1102_coef);
        m1102_ecrit_coef = root.findViewById(R.id.m1102_ecrit_coef);
        m1102_tp_coef = root.findViewById(R.id.m1102_tp_coef);
        m1102_note = root.findViewById(R.id.m1102_note);
        m1102_ecrit_note = root.findViewById(R.id.m1102_ecrit_note);
        m1102_tp_note = root.findViewById(R.id.m1102_tp_note);

        m1103_name = root.findViewById(R.id.m1103_name);
        m1103_coef = root.findViewById(R.id.m1103_coef);
        m1103_ecrit_coef = root.findViewById(R.id.m1103_ecrit_coef);
        m1103_tp_coef = root.findViewById(R.id.m1103_tp_coef);
        m1103_note = root.findViewById(R.id.m1103_note);
        m1103_ecrit_note = root.findViewById(R.id.m1103_ecrit_note);
        m1103_tp_note = root.findViewById(R.id.m1103_tp_note);

        m1104_name = root.findViewById(R.id.m1104_name);
        m1104_coef = root.findViewById(R.id.m1104_coef);
        m1104_ecrit_coef = root.findViewById(R.id.m1104_ecrit_coef);
        m1104_tp_coef = root.findViewById(R.id.m1104_tp_coef);
        m1104_note = root.findViewById(R.id.m1104_note);
        m1104_ecrit_note = root.findViewById(R.id.m1104_ecrit_note);
        m1104_tp_note = root.findViewById(R.id.m1104_tp_note);

        m1105_name = root.findViewById(R.id.m1105_name);
        m1105_coef = root.findViewById(R.id.m1105_coef);
        m1105_webtp_coef = root.findViewById(R.id.m1105_webtp_coef);
        m1105_comecrit_coef = root.findViewById(R.id.m1105_comecrit_coef);
        m1105_comtp_coef = root.findViewById(R.id.m1105_comtp_coef);
        m1105_note = root.findViewById(R.id.m1105_note);
        m1105_webtp_note = root.findViewById(R.id.m1105_webtp_note);
        m1105_comecrit_note = root.findViewById(R.id.m1105_comecrit_note);
        m1105_comtp_note = root.findViewById(R.id.m1105_comtp_note);

        m1106_name = root.findViewById(R.id.m1106_name);
        m1106_coef = root.findViewById(R.id.m1106_coef);
        m1106_tp_coef = root.findViewById(R.id.m1106_tp_coef);
        m1106_note = root.findViewById(R.id.m1106_note);
        m1106_tp_note = root.findViewById(R.id.m1106_tp_note);

        m1201_name = root.findViewById(R.id.m1201_name);
        m1201_coef = root.findViewById(R.id.m1201_coef);
        m1201_ecrit_coef = root.findViewById(R.id.m1201_ecrit_coef);
        m1201_tp_coef = root.findViewById(R.id.m1201_tp_coef);
        m1201_note = root.findViewById(R.id.m1201_note);
        m1201_ecrit_note = root.findViewById(R.id.m1201_ecrit_note);
        m1201_tp_note = root.findViewById(R.id.m1201_tp_note);

        m1202_name = root.findViewById(R.id.m1202_name);
        m1202_coef = root.findViewById(R.id.m1202_coef);
        m1202_ecrit_coef = root.findViewById(R.id.m1202_ecrit_coef);
        m1202_tp_coef = root.findViewById(R.id.m1202_tp_coef);
        m1202_note = root.findViewById(R.id.m1202_note);
        m1202_ecrit_note = root.findViewById(R.id.m1202_ecrit_note);
        m1202_tp_note = root.findViewById(R.id.m1202_tp_note);

        m1203_name = root.findViewById(R.id.m1203_name);
        m1203_coef = root.findViewById(R.id.m1203_coef);
        m1203_ecrit_coef = root.findViewById(R.id.m1203_ecrit_coef);
        m1203_tp_coef = root.findViewById(R.id.m1203_tp_coef);
        m1203_note = root.findViewById(R.id.m1203_note);
        m1203_ecrit_note = root.findViewById(R.id.m1203_ecrit_note);
        m1203_tp_note = root.findViewById(R.id.m1203_tp_note);

        m1204_name = root.findViewById(R.id.m1204_name);
        m1204_coef = root.findViewById(R.id.m1204_coef);
        m1204_ecrit_coef = root.findViewById(R.id.m1204_ecrit_coef);
        m1204_tp_coef = root.findViewById(R.id.m1204_tp_coef);
        m1204_note = root.findViewById(R.id.m1204_note);
        m1204_ecrit_note = root.findViewById(R.id.m1204_ecrit_note);
        m1204_tp_note = root.findViewById(R.id.m1204_tp_note);

        m1205_name = root.findViewById(R.id.m1205_name);
        m1205_coef = root.findViewById(R.id.m1205_coef);
        m1205_tp_coef = root.findViewById(R.id.m1205_tp_coef);
        m1205_note = root.findViewById(R.id.m1205_note);
        m1205_tp_note = root.findViewById(R.id.m1205_tp_note);

        m1206_name = root.findViewById(R.id.m1206_name);
        m1206_coef = root.findViewById(R.id.m1206_coef);
        m1206_ecrit_coef = root.findViewById(R.id.m1206_ecrit_coef);
        m1206_tp_coef = root.findViewById(R.id.m1206_tp_coef);
        m1206_note = root.findViewById(R.id.m1206_note);
        m1206_ecrit_note = root.findViewById(R.id.m1206_ecrit_note);
        m1206_tp_note = root.findViewById(R.id.m1206_tp_note);

        m1207_name = root.findViewById(R.id.m1207_name);
        m1207_coef = root.findViewById(R.id.m1207_coef);
        m1207_tp_coef = root.findViewById(R.id.m1207_tp_coef);
        m1207_note = root.findViewById(R.id.m1207_note);
        m1207_tp_note = root.findViewById(R.id.m1207_tp_note);

        /**
         * Charge les notes et coef de l'UE11 des SharedPreferences et les affiche
         */
        load2CoefFromSharedPreferences(m1101_name, m1101_ecrit_coef, m1101_tp_coef);
        load2GradeFromSharedPreferences(m1101_name, m1101_ecrit_note, m1101_tp_note);
        refreshTextView.refresh2coef2grade(m1101_note, m1101_coef, m1101_ecrit_note, m1101_ecrit_coef, m1101_tp_note, m1101_tp_coef);

        load2CoefFromSharedPreferences(m1102_name, m1102_ecrit_coef, m1102_tp_coef);
        load2GradeFromSharedPreferences(m1102_name, m1102_ecrit_note, m1102_tp_note);
        refreshTextView.refresh2coef2grade(m1102_note, m1102_coef, m1102_ecrit_note, m1102_ecrit_coef, m1102_tp_note, m1102_tp_coef);

        load2CoefFromSharedPreferences(m1103_name, m1103_ecrit_coef, m1103_tp_coef);
        load2GradeFromSharedPreferences(m1103_name, m1103_ecrit_note, m1103_tp_note);
        refreshTextView.refresh2coef2grade(m1103_note, m1103_coef, m1103_ecrit_note, m1103_ecrit_coef, m1103_tp_note, m1103_tp_coef);

        load2CoefFromSharedPreferences(m1104_name, m1104_ecrit_coef, m1104_tp_coef);
        load2GradeFromSharedPreferences(m1104_name, m1104_ecrit_note, m1104_tp_note);
        refreshTextView.refresh2coef2grade(m1104_note, m1104_coef, m1104_ecrit_note, m1104_ecrit_coef, m1104_tp_note, m1104_tp_coef);

        load3CoefFromSharedPreferences(m1105_name, m1105_webtp_coef, m1105_comecrit_coef, m1105_comtp_coef);
        load3GradeFromSharedPreferences(m1105_name, m1105_webtp_note, m1105_comecrit_note, m1105_comtp_note);
        refreshTextView.refresh3coef3grade(m1105_note, m1105_coef, m1105_webtp_note, m1105_webtp_coef, m1105_comecrit_note, m1105_comecrit_coef, m1105_comtp_note, m1105_comtp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m1106_name, m1106_tp_coef, m1106_tp_note);
        refreshTextView.refresh1coef1grade(m1106_note, m1106_coef, m1106_tp_note, m1106_tp_coef);

        /**
         * Charge les notes et coef de l'UE12 des SharedPreferences et les affiche
         */
        load2CoefFromSharedPreferences(m1201_name, m1201_ecrit_coef, m1201_tp_coef);
        load2GradeFromSharedPreferences(m1201_name, m1201_ecrit_note, m1201_tp_note);
        refreshTextView.refresh2coef2grade(m1201_note, m1201_coef, m1201_ecrit_note, m1201_ecrit_coef, m1201_tp_note, m1201_tp_coef);

        load2CoefFromSharedPreferences(m1202_name, m1202_ecrit_coef, m1202_tp_coef);
        load2GradeFromSharedPreferences(m1202_name, m1202_ecrit_note, m1202_tp_note);
        refreshTextView.refresh2coef2grade(m1202_note, m1202_coef, m1202_ecrit_note, m1202_ecrit_coef, m1202_tp_note, m1202_tp_coef);

        load2CoefFromSharedPreferences(m1203_name, m1203_ecrit_coef, m1203_tp_coef);
        load2GradeFromSharedPreferences(m1203_name, m1203_ecrit_note, m1203_tp_note);
        refreshTextView.refresh2coef2grade(m1203_note, m1203_coef, m1203_ecrit_note, m1203_ecrit_coef, m1203_tp_note, m1203_tp_coef);

        load2CoefFromSharedPreferences(m1204_name, m1204_ecrit_coef, m1204_tp_coef);
        load2GradeFromSharedPreferences(m1204_name, m1204_ecrit_note, m1204_tp_note);
        refreshTextView.refresh2coef2grade(m1204_note, m1204_coef, m1204_ecrit_note, m1204_ecrit_coef, m1204_tp_note, m1204_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m1205_name, m1205_tp_coef, m1205_tp_note);
        refreshTextView.refresh1coef1grade(m1205_note, m1205_coef, m1205_tp_note, m1205_tp_coef);

        load2CoefFromSharedPreferences(m1206_name, m1206_ecrit_coef, m1206_tp_coef);
        load2GradeFromSharedPreferences(m1206_name, m1206_ecrit_note, m1206_tp_note);
        refreshTextView.refresh2coef2grade(m1206_note, m1206_coef, m1206_ecrit_note, m1206_ecrit_coef, m1206_tp_note, m1206_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m1207_name, m1207_tp_coef, m1207_tp_note);
        refreshTextView.refresh1coef1grade(m1207_note, m1207_coef, m1207_tp_note, m1207_tp_coef);


        /**
         * Calcul des moyennes
         */
        calculerUE11Moyenne();
        calculerUE12Moyenne();
        calculerMoyenneGenerale();

        /**
         * Listener sur les EditText et TextView pour changer les notes et coef de l'UE11
         */
        m1101_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1101_note, m1101_coef, m1101_ecrit_note, m1101_ecrit_coef, m1101_tp_note, m1101_tp_coef);
                save2CoefInSharedPreferences(m1101_name, m1101_ecrit_coef, m1101_tp_coef);
                save2GradeInSharedPreferences(m1101_name, m1101_ecrit_note, m1101_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1101_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1101_note, m1101_coef, m1101_ecrit_note, m1101_ecrit_coef, m1101_tp_note, m1101_tp_coef);
                save2CoefInSharedPreferences(m1101_name, m1101_ecrit_coef, m1101_tp_coef);
                save2GradeInSharedPreferences(m1101_name, m1101_ecrit_note, m1101_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1101_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1101_note, m1101_coef, m1101_ecrit_note, m1101_ecrit_coef, m1101_tp_note, m1101_tp_coef);
                save2GradeInSharedPreferences(m1101_name, m1101_ecrit_note, m1101_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1101_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1101_note, m1101_coef, m1101_ecrit_note, m1101_ecrit_coef, m1101_tp_note, m1101_tp_coef);
                save2GradeInSharedPreferences(m1101_name, m1101_ecrit_note, m1101_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1102_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1102_note, m1102_coef, m1102_ecrit_note, m1102_ecrit_coef, m1102_tp_note, m1102_tp_coef);
                save2CoefInSharedPreferences(m1102_name, m1102_ecrit_coef, m1102_tp_coef);
                save2GradeInSharedPreferences(m1102_name, m1102_ecrit_note, m1102_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1102_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1102_note, m1102_coef, m1102_ecrit_note, m1102_ecrit_coef, m1102_tp_note, m1102_tp_coef);
                save2CoefInSharedPreferences(m1102_name, m1102_ecrit_coef, m1102_tp_coef);
                save2GradeInSharedPreferences(m1102_name, m1102_ecrit_note, m1102_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1102_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1102_note, m1102_coef, m1102_ecrit_note, m1102_ecrit_coef, m1102_tp_note, m1102_tp_coef);
                save2GradeInSharedPreferences(m1102_name, m1102_ecrit_note, m1102_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1102_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1102_note, m1102_coef, m1102_ecrit_note, m1102_ecrit_coef, m1102_tp_note, m1102_tp_coef);
                save2GradeInSharedPreferences(m1102_name, m1102_ecrit_note, m1102_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1103_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1103_note, m1103_coef, m1103_ecrit_note, m1103_ecrit_coef, m1103_tp_note, m1103_tp_coef);
                save2CoefInSharedPreferences(m1103_name, m1103_ecrit_coef, m1103_tp_coef);
                save2GradeInSharedPreferences(m1103_name, m1103_ecrit_note, m1103_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1103_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1103_note, m1103_coef, m1103_ecrit_note, m1103_ecrit_coef, m1103_tp_note, m1103_tp_coef);
                save2CoefInSharedPreferences(m1103_name, m1103_ecrit_coef, m1103_tp_coef);
                save2GradeInSharedPreferences(m1103_name, m1103_ecrit_note, m1103_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1103_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1103_note, m1103_coef, m1103_ecrit_note, m1103_ecrit_coef, m1103_tp_note, m1103_tp_coef);
                save2GradeInSharedPreferences(m1103_name, m1103_ecrit_note, m1103_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1103_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1103_note, m1103_coef, m1103_ecrit_note, m1103_ecrit_coef, m1103_tp_note, m1103_tp_coef);
                save2GradeInSharedPreferences(m1103_name, m1103_ecrit_note, m1103_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1104_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1104_note, m1104_coef, m1104_ecrit_note, m1104_ecrit_coef, m1104_tp_note, m1104_tp_coef);
                save2CoefInSharedPreferences(m1104_name, m1104_ecrit_coef, m1104_tp_coef);
                save2GradeInSharedPreferences(m1104_name, m1104_ecrit_note, m1104_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1104_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1104_note, m1104_coef, m1104_ecrit_note, m1104_ecrit_coef, m1104_tp_note, m1104_tp_coef);
                save2CoefInSharedPreferences(m1104_name, m1104_ecrit_coef, m1104_tp_coef);
                save2GradeInSharedPreferences(m1104_name, m1104_ecrit_note, m1104_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1104_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1104_note, m1104_coef, m1104_ecrit_note, m1104_ecrit_coef, m1104_tp_note, m1104_tp_coef);
                save2GradeInSharedPreferences(m1104_name, m1104_ecrit_note, m1104_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1104_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1104_note, m1104_coef, m1104_ecrit_note, m1104_ecrit_coef, m1104_tp_note, m1104_tp_coef);
                save2GradeInSharedPreferences(m1104_name, m1104_ecrit_note, m1104_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1105_webtp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m1105_note, m1105_coef, m1105_webtp_note, m1105_webtp_coef, m1105_comecrit_note, m1105_comecrit_coef, m1105_comtp_note, m1105_comtp_coef);
                save3CoefInSharedPreferences(m1105_name, m1105_webtp_coef, m1105_comecrit_coef, m1105_comtp_coef);
                save3GradeInSharedPreferences(m1105_name, m1105_webtp_note, m1105_comecrit_note, m1105_comtp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1105_comecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m1105_note, m1105_coef, m1105_webtp_note, m1105_webtp_coef, m1105_comecrit_note, m1105_comecrit_coef, m1105_comtp_note, m1105_comtp_coef);
                save3CoefInSharedPreferences(m1105_name, m1105_webtp_coef, m1105_comecrit_coef, m1105_comtp_coef);
                save3GradeInSharedPreferences(m1105_name, m1105_webtp_note, m1105_comecrit_note, m1105_comtp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1105_comtp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m1105_note, m1105_coef, m1105_webtp_note, m1105_webtp_coef, m1105_comecrit_note, m1105_comecrit_coef, m1105_comtp_note, m1105_comtp_coef);
                save3CoefInSharedPreferences(m1105_name, m1105_webtp_coef, m1105_comecrit_coef, m1105_comtp_coef);
                save3GradeInSharedPreferences(m1105_name, m1105_webtp_note, m1105_comecrit_note, m1105_comtp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1105_webtp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m1105_note, m1105_coef, m1105_webtp_note, m1105_webtp_coef, m1105_comecrit_note, m1105_comecrit_coef, m1105_comtp_note, m1105_comtp_coef);
                save3GradeInSharedPreferences(m1105_name, m1105_webtp_note, m1105_comecrit_note, m1105_comtp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1105_comecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m1105_note, m1105_coef, m1105_webtp_note, m1105_webtp_coef, m1105_comecrit_note, m1105_comecrit_coef, m1105_comtp_note, m1105_comtp_coef);
                save3GradeInSharedPreferences(m1105_name, m1105_webtp_note, m1105_comecrit_note, m1105_comtp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1105_comtp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh3coef3grade(m1105_note, m1105_coef, m1105_webtp_note, m1105_webtp_coef, m1105_comecrit_note, m1105_comecrit_coef, m1105_comtp_note, m1105_comtp_coef);
                save3GradeInSharedPreferences(m1105_name, m1105_webtp_note, m1105_comecrit_note, m1105_comtp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1106_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m1106_note, m1106_coef, m1106_tp_note, m1106_tp_coef);
                saveCoefGradeTPInSharedPreferences(m1106_name, m1106_tp_coef, m1106_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1106_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m1106_note, m1106_coef, m1106_tp_note, m1106_tp_coef);
                saveCoefGradeTPInSharedPreferences(m1106_name, m1106_tp_coef, m1106_tp_note);
                calculerUE11Moyenne();
                calculerMoyenneGenerale();
            }
        });

        /**
         * Listener sur les EditText et TextView pour changer les notes et coef de l'UE12
         */
        m1201_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1201_note, m1201_coef, m1201_ecrit_note, m1201_ecrit_coef, m1201_tp_note, m1201_tp_coef);
                save2CoefInSharedPreferences(m1201_name, m1201_ecrit_coef, m1201_tp_coef);
                save2GradeInSharedPreferences(m1201_name, m1201_ecrit_note, m1201_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1201_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1201_note, m1201_coef, m1201_ecrit_note, m1201_ecrit_coef, m1201_tp_note, m1201_tp_coef);
                save2CoefInSharedPreferences(m1201_name, m1201_ecrit_coef, m1201_tp_coef);
                save2GradeInSharedPreferences(m1201_name, m1201_ecrit_note, m1201_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1201_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1201_note, m1201_coef, m1201_ecrit_note, m1201_ecrit_coef, m1201_tp_note, m1201_tp_coef);
                save2GradeInSharedPreferences(m1201_name, m1201_ecrit_note, m1201_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1201_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1201_note, m1201_coef, m1201_ecrit_note, m1201_ecrit_coef, m1201_tp_note, m1201_tp_coef);
                save2GradeInSharedPreferences(m1201_name, m1201_ecrit_note, m1201_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1202_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1202_note, m1202_coef, m1202_ecrit_note, m1202_ecrit_coef, m1202_tp_note, m1202_tp_coef);
                save2CoefInSharedPreferences(m1202_name, m1202_ecrit_coef, m1202_tp_coef);
                save2GradeInSharedPreferences(m1202_name, m1202_ecrit_note, m1202_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1202_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1202_note, m1202_coef, m1202_ecrit_note, m1202_ecrit_coef, m1202_tp_note, m1202_tp_coef);
                save2CoefInSharedPreferences(m1202_name, m1202_ecrit_coef, m1202_tp_coef);
                save2GradeInSharedPreferences(m1202_name, m1202_ecrit_note, m1202_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1202_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1202_note, m1202_coef, m1202_ecrit_note, m1202_ecrit_coef, m1202_tp_note, m1202_tp_coef);
                save2GradeInSharedPreferences(m1202_name, m1202_ecrit_note, m1202_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1202_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1202_note, m1202_coef, m1202_ecrit_note, m1202_ecrit_coef, m1202_tp_note, m1202_tp_coef);
                save2GradeInSharedPreferences(m1202_name, m1202_ecrit_note, m1202_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1203_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1203_note, m1203_coef, m1203_ecrit_note, m1203_ecrit_coef, m1203_tp_note, m1203_tp_coef);
                save2CoefInSharedPreferences(m1203_name, m1203_ecrit_coef, m1203_tp_coef);
                save2GradeInSharedPreferences(m1203_name, m1203_ecrit_note, m1203_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1203_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1203_note, m1203_coef, m1203_ecrit_note, m1203_ecrit_coef, m1203_tp_note, m1203_tp_coef);
                save2CoefInSharedPreferences(m1203_name, m1203_ecrit_coef, m1203_tp_coef);
                save2GradeInSharedPreferences(m1203_name, m1203_ecrit_note, m1203_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1203_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1203_note, m1203_coef, m1203_ecrit_note, m1203_ecrit_coef, m1203_tp_note, m1203_tp_coef);
                save2GradeInSharedPreferences(m1203_name, m1203_ecrit_note, m1203_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1203_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1203_note, m1203_coef, m1203_ecrit_note, m1203_ecrit_coef, m1203_tp_note, m1203_tp_coef);
                save2GradeInSharedPreferences(m1203_name, m1203_ecrit_note, m1203_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1204_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1204_note, m1204_coef, m1204_ecrit_note, m1204_ecrit_coef, m1204_tp_note, m1204_tp_coef);
                save2CoefInSharedPreferences(m1204_name, m1204_ecrit_coef, m1204_tp_coef);
                save2GradeInSharedPreferences(m1204_name, m1204_ecrit_note, m1204_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1204_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1204_note, m1204_coef, m1204_ecrit_note, m1204_ecrit_coef, m1204_tp_note, m1204_tp_coef);
                save2CoefInSharedPreferences(m1204_name, m1204_ecrit_coef, m1204_tp_coef);
                save2GradeInSharedPreferences(m1204_name, m1204_ecrit_note, m1204_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1204_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1204_note, m1204_coef, m1204_ecrit_note, m1204_ecrit_coef, m1204_tp_note, m1204_tp_coef);
                save2GradeInSharedPreferences(m1204_name, m1204_ecrit_note, m1204_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1204_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1204_note, m1204_coef, m1204_ecrit_note, m1204_ecrit_coef, m1204_tp_note, m1204_tp_coef);
                save2GradeInSharedPreferences(m1204_name, m1204_ecrit_note, m1204_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1205_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m1205_note, m1205_coef, m1205_tp_note, m1205_tp_coef);
                saveCoefGradeTPInSharedPreferences(m1205_name, m1205_tp_coef, m1205_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1205_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m1205_note, m1205_coef, m1205_tp_note, m1205_tp_coef);
                saveCoefGradeTPInSharedPreferences(m1205_name, m1205_tp_coef, m1205_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1206_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1206_note, m1206_coef, m1206_ecrit_note, m1206_ecrit_coef, m1206_tp_note, m1206_tp_coef);
                save2CoefInSharedPreferences(m1206_name, m1206_ecrit_coef, m1206_tp_coef);
                save2GradeInSharedPreferences(m1206_name, m1206_ecrit_note, m1206_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1206_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1206_note, m1206_coef, m1206_ecrit_note, m1206_ecrit_coef, m1206_tp_note, m1206_tp_coef);
                save2CoefInSharedPreferences(m1206_name, m1206_ecrit_coef, m1206_tp_coef);
                save2GradeInSharedPreferences(m1206_name, m1206_ecrit_note, m1206_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1206_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1206_note, m1206_coef, m1206_ecrit_note, m1206_ecrit_coef, m1206_tp_note, m1206_tp_coef);
                save2GradeInSharedPreferences(m1206_name, m1206_ecrit_note, m1206_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1206_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m1206_note, m1206_coef, m1206_ecrit_note, m1206_ecrit_coef, m1206_tp_note, m1206_tp_coef);
                save2GradeInSharedPreferences(m1206_name, m1206_ecrit_note, m1206_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m1207_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m1207_note, m1207_coef, m1207_tp_note, m1207_tp_coef);
                saveCoefGradeTPInSharedPreferences(m1207_name, m1207_tp_coef, m1207_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m1207_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m1207_note, m1207_coef, m1207_tp_note, m1207_tp_coef);
                saveCoefGradeTPInSharedPreferences(m1207_name, m1207_tp_coef, m1207_tp_note);
                calculerUE12Moyenne();
                calculerMoyenneGenerale();
            }
        });

        return root;
    }

    /**
     * Calcul de la moyenne de l'UE11
     */
    public void calculerUE11Moyenne() {
        sommecoefue11 = 0;
        float ue11 = 0;

        for (int i = 0; i < tableau_s1.getChildCount(); i++) {
            // On cherche les coefficients et notes du tableau avec les tags
            TextView coef = tableau_s1.getChildAt(i).findViewWithTag("coef1");
            TextView note = tableau_s1.getChildAt(i).findViewWithTag("note1");
            if (coef == null || note == null) continue;
            DecimalFormat decimalFormat = new DecimalFormat();
            try {
                // On fait le calcul
                float coefvalue = decimalFormat.parse(coef.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                float notevalue = decimalFormat.parse(note.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                ue11 += coefvalue * notevalue;
                sommecoefue11 += coefvalue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ue11_moyenne.setText(" " + Math.floor((ue11/sommecoefue11)*100)/100);
    }

    /**
     * Calcul de la moyenne de l'UE12
     */
    public void calculerUE12Moyenne() {
        sommecoefue12 = 0;
        float ue12 = 0;

        for (int i = 0; i < tableau_s1.getChildCount(); i++) {
            TextView coef = tableau_s1.getChildAt(i).findViewWithTag("coef2");
            TextView note = tableau_s1.getChildAt(i).findViewWithTag("note2");
            if (coef == null || note == null) continue;
            DecimalFormat decimalFormat = new DecimalFormat();
            try {
                float coefvalue = decimalFormat.parse(coef.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                float notevalue = decimalFormat.parse(note.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                ue12 += coefvalue * notevalue;
                sommecoefue12 += coefvalue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ue12_moyenne.setText(" " + Math.floor((ue12/sommecoefue12)*100)/100);
    }

    /**
     * Calcul de la moyenne générale
     */
    public void calculerMoyenneGenerale() {
        float sommeTotalCoef = sommecoefue11 + sommecoefue12;
        float s1 = (Float.parseFloat(ue11_moyenne.getText().toString()) * sommecoefue11) + (Float.parseFloat(ue12_moyenne.getText().toString()) * sommecoefue12);

        moyenne_s1.setText(" " + Math.floor((s1/sommeTotalCoef)*100)/100);
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