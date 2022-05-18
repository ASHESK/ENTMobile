package com.example.entmobile.results.s3;

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

public class S3Fragment extends Fragment {

    private TableLayout tableau_s3;     // Ensemble du tableau du fragment contenant les notes et les matières

    /**
     * Moyennes calculées
     */
    private TextView moyenne_s3;
    private TextView ue31_moyenne;
    private TextView ue32_moyenne;
    private TextView ue33_moyenne;

    /**
     * Noms, coefficients et notes de l'UE31
     */
    private TextView m3101_name;
    private TextView m3101_coef;
    private EditText m3101_ecrit_coef;
    private EditText m3101_tp_coef;
    private TextView m3101_note;
    private EditText m3101_ecrit_note;
    private EditText m3101_tp_note;

    private TextView m3102_name;
    private TextView m3102_coef;
    private EditText m3102_ecrit_coef;
    private EditText m3102_tp_coef;
    private TextView m3102_note;
    private EditText m3102_ecrit_note;
    private EditText m3102_tp_note;

    private TextView m3103_name;
    private TextView m3103_coef;
    private EditText m3103_ecrit_coef;
    private EditText m3103_tp_coef;
    private TextView m3103_note;
    private EditText m3103_ecrit_note;
    private EditText m3103_tp_note;

    private TextView m3104_name;
    private TextView m3104_coef;
    private EditText m3104_ecrit_coef;
    private EditText m3104_tp_coef;
    private TextView m3104_note;
    private EditText m3104_ecrit_note;
    private EditText m3104_tp_note;

    private TextView m3105_name;
    private TextView m3105_coef;
    private EditText m3105_ecrit_coef;
    private EditText m3105_tp_coef;
    private TextView m3105_note;
    private EditText m3105_ecrit_note;
    private EditText m3105_tp_note;

    private TextView m3106_name;
    private TextView m3106_coef;
    private EditText m3106_ecrit_coef;
    private EditText m3106_tp_coef;
    private TextView m3106_note;
    private EditText m3106_ecrit_note;
    private EditText m3106_tp_note;

    /**
     * Noms, coefficients et notes de l'UE32
     */
    private TextView m3201_name;
    private TextView m3201_coef;
    private EditText m3201_ecrit_coef;
    private EditText m3201_tp_coef;
    private TextView m3201_note;
    private EditText m3201_ecrit_note;
    private EditText m3201_tp_note;

    private TextView m3202_name;
    private TextView m3202_coef;
    private EditText m3202_tp_coef;
    private TextView m3202_note;
    private EditText m3202_tp_note;

    private TextView m3203_name;
    private TextView m3203_coef;
    private EditText m3203_ecrit_coef;
    private EditText m3203_tp_coef;
    private TextView m3203_note;
    private EditText m3203_ecrit_note;
    private EditText m3203_tp_note;

    private TextView m3204_name;
    private TextView m3204_coef;
    private EditText m3204_ecrit_coef;
    private EditText m3204_tp_coef;
    private TextView m3204_note;
    private EditText m3204_ecrit_note;
    private EditText m3204_tp_note;

    private TextView m3205_name;
    private TextView m3205_coef;
    private EditText m3205_tp_coef;
    private TextView m3205_note;
    private EditText m3205_tp_note;

    private TextView m3206_name;
    private TextView m3206_coef;
    private EditText m3206_tp_coef;
    private TextView m3206_note;
    private EditText m3206_tp_note;

    /**
     * Noms, coefficients et notes de l'UE33
     */
    private TextView m3301_name;
    private TextView m3301_coef;
    private EditText m3301_ecrit_coef;
    private EditText m3301_tp_coef;
    private TextView m3301_note;
    private EditText m3301_ecrit_note;
    private EditText m3301_tp_note;

    private TextView m3302_name;
    private TextView m3302_coef;
    private EditText m3302_tp_coef;
    private TextView m3302_note;
    private EditText m3302_tp_note;

    private TextView m3303_name;
    private TextView m3303_coef;
    private EditText m3303_tp_coef;
    private TextView m3303_note;
    private EditText m3303_tp_note;

    private RefreshTextView refreshTextView;        // Rafraichit les éléments lorsqu'une note ou un coefficient est rentré

    /**
     * Somme des coefficients des UE
     */
    private float sommecoefue31;
    private float sommecoefue32;
    private float sommecoefue33;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_s3, container, false);
        refreshTextView = new RefreshTextView();

        /**
         * Initialisation des TextView et EditText
         */
        tableau_s3 = root.findViewById(R.id.tableau_s3);

        moyenne_s3 = root.findViewById(R.id.moyenne_s3);
        ue31_moyenne = root.findViewById(R.id.ue31_moyenne);
        ue32_moyenne = root.findViewById(R.id.ue32_moyenne);
        ue33_moyenne = root.findViewById(R.id.ue33_moyenne);

        m3101_name = root.findViewById(R.id.m3101_name);
        m3101_coef = root.findViewById(R.id.m3101_coef);
        m3101_ecrit_coef = root.findViewById(R.id.m3101_ecrit_coef);
        m3101_tp_coef = root.findViewById(R.id.m3101_tp_coef);
        m3101_note = root.findViewById(R.id.m3101_note);
        m3101_ecrit_note = root.findViewById(R.id.m3101_ecrit_note);
        m3101_tp_note = root.findViewById(R.id.m3101_tp_note);

        m3102_name = root.findViewById(R.id.m3102_name);
        m3102_coef = root.findViewById(R.id.m3102_coef);
        m3102_ecrit_coef = root.findViewById(R.id.m3102_ecrit_coef);
        m3102_tp_coef = root.findViewById(R.id.m3102_tp_coef);
        m3102_note = root.findViewById(R.id.m3102_note);
        m3102_ecrit_note = root.findViewById(R.id.m3102_ecrit_note);
        m3102_tp_note = root.findViewById(R.id.m3102_tp_note);

        m3103_name = root.findViewById(R.id.m3103_name);
        m3103_coef = root.findViewById(R.id.m3103_coef);
        m3103_ecrit_coef = root.findViewById(R.id.m3103_ecrit_coef);
        m3103_tp_coef = root.findViewById(R.id.m3103_tp_coef);
        m3103_note = root.findViewById(R.id.m3103_note);
        m3103_ecrit_note = root.findViewById(R.id.m3103_ecrit_note);
        m3103_tp_note = root.findViewById(R.id.m3103_tp_note);

        m3104_name = root.findViewById(R.id.m3104_name);
        m3104_coef = root.findViewById(R.id.m3104_coef);
        m3104_ecrit_coef = root.findViewById(R.id.m3104_ecrit_coef);
        m3104_tp_coef = root.findViewById(R.id.m3104_tp_coef);
        m3104_note = root.findViewById(R.id.m3104_note);
        m3104_ecrit_note = root.findViewById(R.id.m3104_ecrit_note);
        m3104_tp_note = root.findViewById(R.id.m3104_tp_note);

        m3105_name = root.findViewById(R.id.m3105_name);
        m3105_coef = root.findViewById(R.id.m3105_coef);
        m3105_ecrit_coef = root.findViewById(R.id.m3105_ecrit_coef);
        m3105_tp_coef = root.findViewById(R.id.m3105_tp_coef);
        m3105_note = root.findViewById(R.id.m3105_note);
        m3105_ecrit_note = root.findViewById(R.id.m3105_ecrit_note);
        m3105_tp_note = root.findViewById(R.id.m3105_tp_note);

        m3106_name = root.findViewById(R.id.m4104c_name);
        m3106_coef = root.findViewById(R.id.m4104c_coef);
        m3106_ecrit_coef = root.findViewById(R.id.m4104c_ecrit_coef);
        m3106_tp_coef = root.findViewById(R.id.m4104c_tp_coef);
        m3106_note = root.findViewById(R.id.m4104c_note);
        m3106_ecrit_note = root.findViewById(R.id.m4104c_ecrit_note);
        m3106_tp_note = root.findViewById(R.id.m4104c_tp_note);

        m3201_name = root.findViewById(R.id.m3201_name);
        m3201_coef = root.findViewById(R.id.m3201_coef);
        m3201_ecrit_coef = root.findViewById(R.id.m3201_ecrit_coef);
        m3201_tp_coef = root.findViewById(R.id.m3201_tp_coef);
        m3201_note = root.findViewById(R.id.m3201_note);
        m3201_ecrit_note = root.findViewById(R.id.m3201_ecrit_note);
        m3201_tp_note = root.findViewById(R.id.m3201_tp_note);

        m3202_name = root.findViewById(R.id.m3202_name);
        m3202_coef = root.findViewById(R.id.m3202_coef);
        m3202_tp_coef = root.findViewById(R.id.m3202_tp_coef);
        m3202_note = root.findViewById(R.id.m3202_note);
        m3202_tp_note = root.findViewById(R.id.m3202_tp_note);

        m3203_name = root.findViewById(R.id.m3203_name);
        m3203_coef = root.findViewById(R.id.m3203_coef);
        m3203_ecrit_coef = root.findViewById(R.id.m3203_ecrit_coef);
        m3203_tp_coef = root.findViewById(R.id.m3203_tp_coef);
        m3203_note = root.findViewById(R.id.m3203_note);
        m3203_ecrit_note = root.findViewById(R.id.m3203_ecrit_note);
        m3203_tp_note = root.findViewById(R.id.m3203_tp_note);

        m3204_name = root.findViewById(R.id.m3204_name);
        m3204_coef = root.findViewById(R.id.m3204_coef);
        m3204_ecrit_coef = root.findViewById(R.id.m3204_ecrit_coef);
        m3204_tp_coef = root.findViewById(R.id.m3204_tp_coef);
        m3204_note = root.findViewById(R.id.m3204_note);
        m3204_ecrit_note = root.findViewById(R.id.m3204_ecrit_note);
        m3204_tp_note = root.findViewById(R.id.m3204_tp_note);

        m3205_name = root.findViewById(R.id.m3205_name);
        m3205_coef = root.findViewById(R.id.m3205_coef);
        m3205_tp_coef = root.findViewById(R.id.m3205_tp_coef);
        m3205_note = root.findViewById(R.id.m3205_note);
        m3205_tp_note = root.findViewById(R.id.m3205_tp_note);

        m3206_name = root.findViewById(R.id.m3206_name);
        m3206_coef = root.findViewById(R.id.m3206_coef);
        m3206_tp_coef = root.findViewById(R.id.m3206_tp_coef);
        m3206_note = root.findViewById(R.id.m3206_note);
        m3206_tp_note = root.findViewById(R.id.m3206_tp_note);

        m3301_name = root.findViewById(R.id.m3301_name);
        m3301_coef = root.findViewById(R.id.m3301_coef);
        m3301_ecrit_coef = root.findViewById(R.id.m3301_ecrit_coef);
        m3301_tp_coef = root.findViewById(R.id.m3301_tp_coef);
        m3301_note = root.findViewById(R.id.m3301_note);
        m3301_ecrit_note = root.findViewById(R.id.m3301_ecrit_note);
        m3301_tp_note = root.findViewById(R.id.m3301_tp_note);

        m3302_name = root.findViewById(R.id.m3302_name);
        m3302_coef = root.findViewById(R.id.m3302_coef);
        m3302_tp_coef = root.findViewById(R.id.m3302_tp_coef);
        m3302_note = root.findViewById(R.id.m3302_note);
        m3302_tp_note = root.findViewById(R.id.m3302_tp_note);

        m3303_name = root.findViewById(R.id.m3303_name);
        m3303_coef = root.findViewById(R.id.m3303_coef);
        m3303_tp_coef = root.findViewById(R.id.m3303_tp_coef);
        m3303_note = root.findViewById(R.id.m3303_note);
        m3303_tp_note = root.findViewById(R.id.m3303_tp_note);


        /**
         * Charge les notes et coef de l'UE31 des SharedPreferences et les affiche
         */
        load2CoefFromSharedPreferences(m3101_name, m3101_ecrit_coef, m3101_tp_coef);
        load2GradeFromSharedPreferences(m3101_name, m3101_ecrit_note, m3101_tp_note);
        refreshTextView.refresh2coef2grade(m3101_note, m3101_coef, m3101_ecrit_note, m3101_ecrit_coef, m3101_tp_note, m3101_tp_coef);

        load2CoefFromSharedPreferences(m3102_name, m3102_ecrit_coef, m3102_tp_coef);
        load2GradeFromSharedPreferences(m3102_name, m3102_ecrit_note, m3102_tp_note);
        refreshTextView.refresh2coef2grade(m3102_note, m3102_coef, m3102_ecrit_note, m3102_ecrit_coef, m3102_tp_note, m3102_tp_coef);

        load2CoefFromSharedPreferences(m3103_name, m3103_ecrit_coef, m3103_tp_coef);
        load2GradeFromSharedPreferences(m3103_name, m3103_ecrit_note, m3103_tp_note);
        refreshTextView.refresh2coef2grade(m3103_note, m3103_coef, m3103_ecrit_note, m3103_ecrit_coef, m3103_tp_note, m3103_tp_coef);

        load2CoefFromSharedPreferences(m3104_name, m3104_ecrit_coef, m3104_tp_coef);
        load2GradeFromSharedPreferences(m3104_name, m3104_ecrit_note, m3104_tp_note);
        refreshTextView.refresh2coef2grade(m3104_note, m3104_coef, m3104_ecrit_note, m3104_ecrit_coef, m3104_tp_note, m3104_tp_coef);

        load2CoefFromSharedPreferences(m3105_name, m3105_ecrit_coef, m3105_tp_coef);
        load2GradeFromSharedPreferences(m3105_name, m3105_ecrit_note, m3105_tp_note);
        refreshTextView.refresh2coef2grade(m3105_note, m3105_coef, m3105_ecrit_note, m3105_ecrit_coef, m3105_tp_note, m3105_tp_coef);

        load2CoefFromSharedPreferences(m3106_name, m3106_ecrit_coef, m3106_tp_coef);
        load2GradeFromSharedPreferences(m3106_name, m3106_ecrit_note, m3106_tp_note);
        refreshTextView.refresh2coef2grade(m3106_note, m3106_coef, m3106_ecrit_note, m3106_ecrit_coef, m3106_tp_note, m3106_tp_coef);

        /**
         * Charge les notes et coef de l'UE32 des SharedPreferences et les affiche
         */
        load2CoefFromSharedPreferences(m3201_name, m3201_ecrit_coef, m3201_tp_coef);
        load2GradeFromSharedPreferences(m3201_name, m3201_ecrit_note, m3201_tp_note);
        refreshTextView.refresh2coef2grade(m3201_note, m3201_coef, m3201_ecrit_note, m3201_ecrit_coef, m3201_tp_note, m3201_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m3202_name, m3202_tp_coef, m3202_tp_note);
        refreshTextView.refresh1coef1grade(m3202_note, m3202_coef, m3202_tp_note, m3202_tp_coef);

        load2CoefFromSharedPreferences(m3203_name, m3203_ecrit_coef, m3203_tp_coef);
        load2GradeFromSharedPreferences(m3203_name, m3203_ecrit_note, m3203_tp_note);
        refreshTextView.refresh2coef2grade(m3203_note, m3203_coef, m3203_ecrit_note, m3203_ecrit_coef, m3203_tp_note, m3203_tp_coef);

        load2CoefFromSharedPreferences(m3204_name, m3204_ecrit_coef, m3204_tp_coef);
        load2GradeFromSharedPreferences(m3204_name, m3204_ecrit_note, m3204_tp_note);
        refreshTextView.refresh2coef2grade(m3204_note, m3204_coef, m3204_ecrit_note, m3204_ecrit_coef, m3204_tp_note, m3204_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m3205_name, m3205_tp_coef, m3205_tp_note);
        refreshTextView.refresh1coef1grade(m3205_note, m3205_coef, m3205_tp_note, m3205_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m3206_name, m3206_tp_coef, m3206_tp_note);
        refreshTextView.refresh1coef1grade(m3206_note, m3206_coef, m3206_tp_note, m3206_tp_coef);

        /**
         * Charge les notes et coef de l'UE33 des SharedPreferences et les affiche
         */
        load2CoefFromSharedPreferences(m3301_name, m3301_ecrit_coef, m3301_tp_coef);
        load2GradeFromSharedPreferences(m3301_name, m3301_ecrit_note, m3301_tp_note);
        refreshTextView.refresh2coef2grade(m3301_note, m3301_coef, m3301_ecrit_note, m3301_ecrit_coef, m3301_tp_note, m3301_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m3302_name, m3302_tp_coef, m3302_tp_note);
        refreshTextView.refresh1coef1grade(m3302_note, m3302_coef, m3302_tp_note, m3302_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m3303_name, m3303_tp_coef, m3303_tp_note);
        refreshTextView.refresh1coef1grade(m3303_note, m3303_coef, m3303_tp_note, m3303_tp_coef);

        /**
         * Calcul des moyennes
         */
        calculerUE31Moyenne();
        calculerUE32Moyenne();
        calculerUE33Moyenne();
        calculerMoyenneGenerale();

        /**
         * Listener sur les EditText et TextView pour changer les notes et coef de l'UE31
         */
        m3101_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3101_note, m3101_coef, m3101_ecrit_note, m3101_ecrit_coef, m3101_tp_note, m3101_tp_coef);
                save2CoefInSharedPreferences(m3101_name, m3101_ecrit_coef, m3101_tp_coef);
                save2GradeInSharedPreferences(m3101_name, m3101_ecrit_note, m3101_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3101_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3101_note, m3101_coef, m3101_ecrit_note, m3101_ecrit_coef, m3101_tp_note, m3101_tp_coef);
                save2CoefInSharedPreferences(m3101_name, m3101_ecrit_coef, m3101_tp_coef);
                save2GradeInSharedPreferences(m3101_name, m3101_ecrit_note, m3101_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3101_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3101_note, m3101_coef, m3101_ecrit_note, m3101_ecrit_coef, m3101_tp_note, m3101_tp_coef);
                save2GradeInSharedPreferences(m3101_name, m3101_ecrit_note, m3101_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3101_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3101_note, m3101_coef, m3101_ecrit_note, m3101_ecrit_coef, m3101_tp_note, m3101_tp_coef);
                save2GradeInSharedPreferences(m3101_name, m3101_ecrit_note, m3101_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3102_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3102_note, m3102_coef, m3102_ecrit_note, m3102_ecrit_coef, m3102_tp_note, m3102_tp_coef);
                save2CoefInSharedPreferences(m3102_name, m3102_ecrit_coef, m3102_tp_coef);
                save2GradeInSharedPreferences(m3102_name, m3102_ecrit_note, m3102_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3102_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3102_note, m3102_coef, m3102_ecrit_note, m3102_ecrit_coef, m3102_tp_note, m3102_tp_coef);
                save2CoefInSharedPreferences(m3102_name, m3102_ecrit_coef, m3102_tp_coef);
                save2GradeInSharedPreferences(m3102_name, m3102_ecrit_note, m3102_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3102_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3102_note, m3102_coef, m3102_ecrit_note, m3102_ecrit_coef, m3102_tp_note, m3102_tp_coef);
                save2GradeInSharedPreferences(m3102_name, m3102_ecrit_note, m3102_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3102_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3102_note, m3102_coef, m3102_ecrit_note, m3102_ecrit_coef, m3102_tp_note, m3102_tp_coef);
                save2GradeInSharedPreferences(m3102_name, m3102_ecrit_note, m3102_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3103_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3103_note, m3103_coef, m3103_ecrit_note, m3103_ecrit_coef, m3103_tp_note, m3103_tp_coef);
                save2CoefInSharedPreferences(m3103_name, m3103_ecrit_coef, m3103_tp_coef);
                save2GradeInSharedPreferences(m3103_name, m3103_ecrit_note, m3103_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3103_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3103_note, m3103_coef, m3103_ecrit_note, m3103_ecrit_coef, m3103_tp_note, m3103_tp_coef);
                save2CoefInSharedPreferences(m3103_name, m3103_ecrit_coef, m3103_tp_coef);
                save2GradeInSharedPreferences(m3103_name, m3103_ecrit_note, m3103_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3103_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3103_note, m3103_coef, m3103_ecrit_note, m3103_ecrit_coef, m3103_tp_note, m3103_tp_coef);
                save2GradeInSharedPreferences(m3103_name, m3103_ecrit_note, m3103_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3103_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3103_note, m3103_coef, m3103_ecrit_note, m3103_ecrit_coef, m3103_tp_note, m3103_tp_coef);
                save2GradeInSharedPreferences(m3103_name, m3103_ecrit_note, m3103_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3104_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3104_note, m3104_coef, m3104_ecrit_note, m3104_ecrit_coef, m3104_tp_note, m3104_tp_coef);
                save2CoefInSharedPreferences(m3104_name, m3104_ecrit_coef, m3104_tp_coef);
                save2GradeInSharedPreferences(m3104_name, m3104_ecrit_note, m3104_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3104_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3104_note, m3104_coef, m3104_ecrit_note, m3104_ecrit_coef, m3104_tp_note, m3104_tp_coef);
                save2CoefInSharedPreferences(m3104_name, m3104_ecrit_coef, m3104_tp_coef);
                save2GradeInSharedPreferences(m3104_name, m3104_ecrit_note, m3104_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3104_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3104_note, m3104_coef, m3104_ecrit_note, m3104_ecrit_coef, m3104_tp_note, m3104_tp_coef);
                save2GradeInSharedPreferences(m3104_name, m3104_ecrit_note, m3104_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3104_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3104_note, m3104_coef, m3104_ecrit_note, m3104_ecrit_coef, m3104_tp_note, m3104_tp_coef);
                save2GradeInSharedPreferences(m3104_name, m3104_ecrit_note, m3104_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3105_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3105_note, m3105_coef, m3105_ecrit_note, m3105_ecrit_coef, m3105_tp_note, m3105_tp_coef);
                save2CoefInSharedPreferences(m3105_name, m3105_ecrit_coef, m3105_tp_coef);
                save2GradeInSharedPreferences(m3105_name, m3105_ecrit_note, m3105_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3105_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3105_note, m3105_coef, m3105_ecrit_note, m3105_ecrit_coef, m3105_tp_note, m3105_tp_coef);
                save2CoefInSharedPreferences(m3105_name, m3105_ecrit_coef, m3105_tp_coef);
                save2GradeInSharedPreferences(m3105_name, m3105_ecrit_note, m3105_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3105_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3105_note, m3105_coef, m3105_ecrit_note, m3105_ecrit_coef, m3105_tp_note, m3105_tp_coef);
                save2GradeInSharedPreferences(m3105_name, m3105_ecrit_note, m3105_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3105_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3105_note, m3105_coef, m3105_ecrit_note, m3105_ecrit_coef, m3105_tp_note, m3105_tp_coef);
                save2GradeInSharedPreferences(m3105_name, m3105_ecrit_note, m3105_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3106_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3106_note, m3106_coef, m3106_ecrit_note, m3106_ecrit_coef, m3106_tp_note, m3106_tp_coef);
                save2CoefInSharedPreferences(m3106_name, m3106_ecrit_coef, m3106_tp_coef);
                save2GradeInSharedPreferences(m3106_name, m3106_ecrit_note, m3106_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3106_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3106_note, m3106_coef, m3106_ecrit_note, m3106_ecrit_coef, m3106_tp_note, m3106_tp_coef);
                save2CoefInSharedPreferences(m3106_name, m3106_ecrit_coef, m3106_tp_coef);
                save2GradeInSharedPreferences(m3106_name, m3106_ecrit_note, m3106_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3106_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3106_note, m3106_coef, m3106_ecrit_note, m3106_ecrit_coef, m3106_tp_note, m3106_tp_coef);
                save2GradeInSharedPreferences(m3106_name, m3106_ecrit_note, m3106_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3106_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3106_note, m3106_coef, m3106_ecrit_note, m3106_ecrit_coef, m3106_tp_note, m3106_tp_coef);
                save2GradeInSharedPreferences(m3106_name, m3106_ecrit_note, m3106_tp_note);
                calculerUE31Moyenne();
                calculerMoyenneGenerale();
            }
        });

        /**
         * Listener sur les EditText et TextView pour changer les notes et coef de l'UE32
         */
        m3201_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3201_note, m3201_coef, m3201_ecrit_note, m3201_ecrit_coef, m3201_tp_note, m3201_tp_coef);
                save2CoefInSharedPreferences(m3201_name, m3201_ecrit_coef, m3201_tp_coef);
                save2GradeInSharedPreferences(m3201_name, m3201_ecrit_note, m3201_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3201_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3201_note, m3201_coef, m3201_ecrit_note, m3201_ecrit_coef, m3201_tp_note, m3201_tp_coef);
                save2CoefInSharedPreferences(m3201_name, m3201_ecrit_coef, m3201_tp_coef);
                save2GradeInSharedPreferences(m3201_name, m3201_ecrit_note, m3201_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3201_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3201_note, m3201_coef, m3201_ecrit_note, m3201_ecrit_coef, m3201_tp_note, m3201_tp_coef);
                save2GradeInSharedPreferences(m3201_name, m3201_ecrit_note, m3201_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3201_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3201_note, m3201_coef, m3201_ecrit_note, m3201_ecrit_coef, m3201_tp_note, m3201_tp_coef);
                save2GradeInSharedPreferences(m3201_name, m3201_ecrit_note, m3201_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3202_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m3202_note, m3202_coef, m3202_tp_note, m3202_tp_coef);
                saveCoefGradeTPInSharedPreferences(m3202_name, m3202_tp_coef, m3202_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3202_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m3202_note, m3202_coef, m3202_tp_note, m3202_tp_coef);
                saveCoefGradeTPInSharedPreferences(m3202_name, m3202_tp_coef, m3202_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3203_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3203_note, m3203_coef, m3203_ecrit_note, m3203_ecrit_coef, m3203_tp_note, m3203_tp_coef);
                save2CoefInSharedPreferences(m3203_name, m3203_ecrit_coef, m3203_tp_coef);
                save2GradeInSharedPreferences(m3203_name, m3203_ecrit_note, m3203_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3203_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3203_note, m3203_coef, m3203_ecrit_note, m3203_ecrit_coef, m3203_tp_note, m3203_tp_coef);
                save2CoefInSharedPreferences(m3203_name, m3203_ecrit_coef, m3203_tp_coef);
                save2GradeInSharedPreferences(m3203_name, m3203_ecrit_note, m3203_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3203_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3203_note, m3203_coef, m3203_ecrit_note, m3203_ecrit_coef, m3203_tp_note, m3203_tp_coef);
                save2GradeInSharedPreferences(m3203_name, m3203_ecrit_note, m3203_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3203_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3203_note, m3203_coef, m3203_ecrit_note, m3203_ecrit_coef, m3203_tp_note, m3203_tp_coef);
                save2GradeInSharedPreferences(m3203_name, m3203_ecrit_note, m3203_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3204_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3204_note, m3204_coef, m3204_ecrit_note, m3204_ecrit_coef, m3204_tp_note, m3204_tp_coef);
                save2CoefInSharedPreferences(m3204_name, m3204_ecrit_coef, m3204_tp_coef);
                save2GradeInSharedPreferences(m3204_name, m3204_ecrit_note, m3204_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3204_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3204_note, m3204_coef, m3204_ecrit_note, m3204_ecrit_coef, m3204_tp_note, m3204_tp_coef);
                save2CoefInSharedPreferences(m3204_name, m3204_ecrit_coef, m3204_tp_coef);
                save2GradeInSharedPreferences(m3204_name, m3204_ecrit_note, m3204_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3204_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3204_note, m3204_coef, m3204_ecrit_note, m3204_ecrit_coef, m3204_tp_note, m3204_tp_coef);
                save2GradeInSharedPreferences(m3204_name, m3204_ecrit_note, m3204_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3204_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3204_note, m3204_coef, m3204_ecrit_note, m3204_ecrit_coef, m3204_tp_note, m3204_tp_coef);
                save2GradeInSharedPreferences(m3204_name, m3204_ecrit_note, m3204_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3205_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m3205_note, m3205_coef, m3205_tp_note, m3205_tp_coef);
                saveCoefGradeTPInSharedPreferences(m3205_name, m3205_tp_coef, m3205_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3205_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m3205_note, m3205_coef, m3205_tp_note, m3205_tp_coef);
                saveCoefGradeTPInSharedPreferences(m3205_name, m3205_tp_coef, m3205_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3206_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m3206_note, m3206_coef, m3206_tp_note, m3206_tp_coef);
                saveCoefGradeTPInSharedPreferences(m3206_name, m3206_tp_coef, m3206_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3206_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m3206_note, m3206_coef, m3206_tp_note, m3206_tp_coef);
                saveCoefGradeTPInSharedPreferences(m3206_name, m3206_tp_coef, m3206_tp_note);
                calculerUE32Moyenne();
                calculerMoyenneGenerale();
            }
        });

        /**
         * Listener sur les EditText et TextView pour changer les notes et coef de l'UE33
         */
        m3301_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3301_note, m3301_coef, m3301_ecrit_note, m3301_ecrit_coef, m3301_tp_note, m3301_tp_coef);
                save2CoefInSharedPreferences(m3301_name, m3301_ecrit_coef, m3301_tp_coef);
                save2GradeInSharedPreferences(m3301_name, m3301_ecrit_note, m3301_tp_note);
                calculerUE33Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3301_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3301_note, m3301_coef, m3301_ecrit_note, m3301_ecrit_coef, m3301_tp_note, m3301_tp_coef);
                save2CoefInSharedPreferences(m3301_name, m3301_ecrit_coef, m3301_tp_coef);
                save2GradeInSharedPreferences(m3301_name, m3301_ecrit_note, m3301_tp_note);
                calculerUE33Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3301_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3301_note, m3301_coef, m3301_ecrit_note, m3301_ecrit_coef, m3301_tp_note, m3301_tp_coef);
                save2GradeInSharedPreferences(m3301_name, m3301_ecrit_note, m3301_tp_note);
                calculerUE33Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3301_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m3301_note, m3301_coef, m3301_ecrit_note, m3301_ecrit_coef, m3301_tp_note, m3301_tp_coef);
                save2GradeInSharedPreferences(m3301_name, m3301_ecrit_note, m3301_tp_note);
                calculerUE33Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3302_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m3302_note, m3302_coef, m3302_tp_note, m3302_tp_coef);
                saveCoefGradeTPInSharedPreferences(m3302_name, m3302_tp_coef, m3302_tp_note);
                calculerUE33Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3302_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m3302_note, m3302_coef, m3302_tp_note, m3302_tp_coef);
                saveCoefGradeTPInSharedPreferences(m3302_name, m3302_tp_coef, m3302_tp_note);
                calculerUE33Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m3303_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m3303_note, m3303_coef, m3303_tp_note, m3303_tp_coef);
                saveCoefGradeTPInSharedPreferences(m3303_name, m3303_tp_coef, m3303_tp_note);
                calculerUE33Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m3303_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m3303_note, m3303_coef, m3303_tp_note, m3303_tp_coef);
                saveCoefGradeTPInSharedPreferences(m3303_name, m3303_tp_coef, m3303_tp_note);
                calculerUE33Moyenne();
                calculerMoyenneGenerale();
            }
        });

        return root;
    }

    /**
     * Calcul de la moyenne de l'UE31
     */
    public void calculerUE31Moyenne() {
        sommecoefue31 = 0;
        float ue31 = 0;

        for (int i = 0; i < tableau_s3.getChildCount(); i++) {
            TextView coef = tableau_s3.getChildAt(i).findViewWithTag("coef1");
            TextView note = tableau_s3.getChildAt(i).findViewWithTag("note1");
            if (coef == null || note == null) continue;
            DecimalFormat decimalFormat = new DecimalFormat();
            try {
                float coefvalue = decimalFormat.parse(coef.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                float notevalue = decimalFormat.parse(note.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                ue31 += coefvalue * notevalue;
                sommecoefue31 += coefvalue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ue31_moyenne.setText(" " + Math.floor((ue31/sommecoefue31)*100)/100);
    }

    /**
     * Calcul de la moyenne de l'UE32
     */
    public void calculerUE32Moyenne() {
        sommecoefue32 = 0;
        float ue32 = 0;

        for (int i = 0; i < tableau_s3.getChildCount(); i++) {
            TextView coef = tableau_s3.getChildAt(i).findViewWithTag("coef2");
            TextView note = tableau_s3.getChildAt(i).findViewWithTag("note2");
            if (coef == null || note == null) continue;
            DecimalFormat decimalFormat = new DecimalFormat();
            try {
                float coefvalue = decimalFormat.parse(coef.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                float notevalue = decimalFormat.parse(note.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                ue32 += coefvalue * notevalue;
                sommecoefue32 += coefvalue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ue32_moyenne.setText(" " + Math.floor((ue32/sommecoefue32)*100)/100);
    }

    /**
     * Calcul de la moyenne de l'UE33
     */
    public void calculerUE33Moyenne() {
        sommecoefue33 = 0;
        float ue33 = 0;

        for (int i = 0; i < tableau_s3.getChildCount(); i++) {
            TextView coef = tableau_s3.getChildAt(i).findViewWithTag("coef3");
            TextView note = tableau_s3.getChildAt(i).findViewWithTag("note3");
            if (coef == null || note == null) continue;
            DecimalFormat decimalFormat = new DecimalFormat();
            try {
                float coefvalue = decimalFormat.parse(coef.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                float notevalue = decimalFormat.parse(note.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                ue33 += coefvalue * notevalue;
                sommecoefue33 += coefvalue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ue33_moyenne.setText(" " + Math.floor((ue33/sommecoefue33)*100)/100);
    }

    /**
     * Calcul de la moyenne générale
     */
    public void calculerMoyenneGenerale() {
        float sommeTotalCoef = sommecoefue31 + sommecoefue32 + sommecoefue33;
        float s3 = (Float.parseFloat(ue31_moyenne.getText().toString()) * sommecoefue31) + (Float.parseFloat(ue32_moyenne.getText().toString()) * sommecoefue32) + (Float.parseFloat(ue33_moyenne.getText().toString()) * sommecoefue33);

        moyenne_s3.setText(" " + Math.floor((s3/sommeTotalCoef)*100)/100);
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

}