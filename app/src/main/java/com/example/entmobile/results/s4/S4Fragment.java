package com.example.entmobile.results.s4;

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

public class S4Fragment extends Fragment {

    private TableLayout tableau_s4;     // Ensemble du tableau du fragment contenant les notes et les matières

    /**
     * Moyennes calculées
     */
    private TextView moyenne_s4;
    private TextView ue41_moyenne;
    private TextView ue42_moyenne;
    private TextView ue43_moyenne;

    /**
     * Noms, coefficients et notes de l'UE41
     */
    private TextView m4101_name;
    private TextView m4101_coef;
    private EditText m4101_ecrit_coef;
    private EditText m4101_tp_coef;
    private TextView m4101_note;
    private EditText m4101_ecrit_note;
    private EditText m4101_tp_note;

    private TextView m4102_name;
    private TextView m4102_coef;
    private EditText m4102_ecrit_coef;
    private EditText m4102_tp_coef;
    private TextView m4102_note;
    private EditText m4102_ecrit_note;
    private EditText m4102_tp_note;

    private TextView m4103_name;
    private TextView m4103_coef;
    private EditText m4103_ecrit_coef;
    private EditText m4103_tp_coef;
    private TextView m4103_note;
    private EditText m4103_ecrit_note;
    private EditText m4103_tp_note;

    private TextView m4104_name;
    private TextView m4104_coef;
    private EditText m4104_ecrit_coef;
    private EditText m4104_tp_coef;
    private TextView m4104_note;
    private EditText m4104_ecrit_note;
    private EditText m4104_tp_note;

    private TextView m4105_name;
    private TextView m4105_coef;
    private EditText m4105_ecrit_coef;
    private EditText m4105_tp_coef;
    private TextView m4105_note;
    private EditText m4105_ecrit_note;
    private EditText m4105_tp_note;

    private TextView m4106_name;
    private TextView m4106_coef;
    private EditText m4106_tp_coef;
    private TextView m4106_note;
    private EditText m4106_tp_note;

    /**
     * Noms, coefficients et notes de l'UE42
     */
    private TextView m4201_name;
    private TextView m4201_coef;
    private EditText m4201_ecrit_coef;
    private EditText m4201_tp_coef;
    private TextView m4201_note;
    private EditText m4201_ecrit_note;
    private EditText m4201_tp_note;

    private TextView m4202_name;
    private TextView m4202_coef;
    private EditText m4202_ecrit_coef;
    private EditText m4202_tp_coef;
    private TextView m4202_note;
    private EditText m4202_ecrit_note;
    private EditText m4202_tp_note;

    private TextView m4203_name;
    private TextView m4203_coef;
    private EditText m4203_tp_coef;
    private TextView m4203_note;
    private EditText m4203_tp_note;

    private TextView m4204_name;
    private TextView m4204_coef;
    private EditText m4204_tp_coef;
    private TextView m4204_note;
    private EditText m4204_tp_note;

    /**
     * Noms, coefficients et notes de l'UE33
     */
    private TextView m4301_name;
    private TextView m4301_coef;
    private EditText m4301_tp_coef;
    private TextView m4301_note;
    private EditText m4301_tp_note;

    private RefreshTextView refreshTextView;        // Rafraichit les éléments lorsqu'une note ou un coefficient est rentré

    /**
     * Somme des coefficients des UE
     */
    private float sommecoefue41;
    private float sommecoefue42;
    private float sommecoefue43;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_s4, container, false);
        refreshTextView = new RefreshTextView();

        /**
         * Initialisation des TextView et EditText
         */
        tableau_s4 = root.findViewById(R.id.tableau_s4);

        moyenne_s4 = root.findViewById(R.id.moyenne_s4);
        ue41_moyenne = root.findViewById(R.id.ue41_moyenne);
        ue42_moyenne = root.findViewById(R.id.ue42_moyenne);
        ue43_moyenne = root.findViewById(R.id.ue43_moyenne);

        m4101_name = root.findViewById(R.id.m4101_name);
        m4101_coef = root.findViewById(R.id.m4101_coef);
        m4101_ecrit_coef = root.findViewById(R.id.m4101_ecrit_coef);
        m4101_tp_coef = root.findViewById(R.id.m4101_tp_coef);
        m4101_note = root.findViewById(R.id.m4101_note);
        m4101_ecrit_note = root.findViewById(R.id.m4101_ecrit_note);
        m4101_tp_note = root.findViewById(R.id.m4101_tp_note);

        m4102_name = root.findViewById(R.id.m4102_name);
        m4102_coef = root.findViewById(R.id.m4102_coef);
        m4102_ecrit_coef = root.findViewById(R.id.m4102_ecrit_coef);
        m4102_tp_coef = root.findViewById(R.id.m4102_tp_coef);
        m4102_note = root.findViewById(R.id.m4102_note);
        m4102_ecrit_note = root.findViewById(R.id.m4102_ecrit_note);
        m4102_tp_note = root.findViewById(R.id.m4102_tp_note);

        m4103_name = root.findViewById(R.id.m4103_name);
        m4103_coef = root.findViewById(R.id.m4103_coef);
        m4103_ecrit_coef = root.findViewById(R.id.m4103_ecrit_coef);
        m4103_tp_coef = root.findViewById(R.id.m4103_tp_coef);
        m4103_note = root.findViewById(R.id.m4103_note);
        m4103_ecrit_note = root.findViewById(R.id.m4103_ecrit_note);
        m4103_tp_note = root.findViewById(R.id.m4103_tp_note);

        m4104_name = root.findViewById(R.id.m4104_name);
        m4104_coef = root.findViewById(R.id.m4104_coef);
        m4104_ecrit_coef = root.findViewById(R.id.m4104_ecrit_coef);
        m4104_tp_coef = root.findViewById(R.id.m4104_tp_coef);
        m4104_note = root.findViewById(R.id.m4104_note);
        m4104_ecrit_note = root.findViewById(R.id.m4104_ecrit_note);
        m4104_tp_note = root.findViewById(R.id.m4104_tp_note);

        m4105_name = root.findViewById(R.id.m4105_name);
        m4105_coef = root.findViewById(R.id.m4105_coef);
        m4105_ecrit_coef = root.findViewById(R.id.m4105_ecrit_coef);
        m4105_tp_coef = root.findViewById(R.id.m4105_tp_coef);
        m4105_note = root.findViewById(R.id.m4105_note);
        m4105_ecrit_note = root.findViewById(R.id.m4105_ecrit_note);
        m4105_tp_note = root.findViewById(R.id.m4105_tp_note);

        m4106_name = root.findViewById(R.id.m4106_name);
        m4106_coef = root.findViewById(R.id.m4106_coef);
        m4106_tp_coef = root.findViewById(R.id.m4106_tp_coef);
        m4106_note = root.findViewById(R.id.m4106_note);
        m4106_tp_note = root.findViewById(R.id.m4106_tp_note);

        m4201_name = root.findViewById(R.id.m4201_name);
        m4201_coef = root.findViewById(R.id.m4201_coef);
        m4201_ecrit_coef = root.findViewById(R.id.m4201_ecrit_coef);
        m4201_tp_coef = root.findViewById(R.id.m4201_tp_coef);
        m4201_note = root.findViewById(R.id.m4201_note);
        m4201_ecrit_note = root.findViewById(R.id.m4201_ecrit_note);
        m4201_tp_note = root.findViewById(R.id.m4201_tp_note);

        m4202_name = root.findViewById(R.id.m4202_name);
        m4202_coef = root.findViewById(R.id.m4202_coef);
        m4202_ecrit_coef = root.findViewById(R.id.m4202_ecrit_coef);
        m4202_tp_coef = root.findViewById(R.id.m4202_tp_coef);
        m4202_note = root.findViewById(R.id.m4202_note);
        m4202_ecrit_note = root.findViewById(R.id.m4202_ecrit_note);
        m4202_tp_note = root.findViewById(R.id.m4202_tp_note);

        m4203_name = root.findViewById(R.id.m4203_name);
        m4203_coef = root.findViewById(R.id.m4203_coef);
        m4203_tp_coef = root.findViewById(R.id.m4203_tp_coef);
        m4203_note = root.findViewById(R.id.m4203_note);
        m4203_tp_note = root.findViewById(R.id.m4203_tp_note);

        m4204_name = root.findViewById(R.id.m4204_name);
        m4204_coef = root.findViewById(R.id.m4204_coef);
        m4204_tp_coef = root.findViewById(R.id.m4204_tp_coef);
        m4204_note = root.findViewById(R.id.m4204_note);
        m4204_tp_note = root.findViewById(R.id.m4204_tp_note);


        m4301_name = root.findViewById(R.id.m4301_name);
        m4301_coef = root.findViewById(R.id.m4301_coef);
        m4301_tp_coef = root.findViewById(R.id.m4301_tp_coef);
        m4301_note = root.findViewById(R.id.m4301_note);
        m4301_tp_note = root.findViewById(R.id.m4301_tp_note);


        /**
         * Charge les notes et coef de l'UE41 des SharedPreferences et les affiche
         */
        load2CoefFromSharedPreferences(m4101_name, m4101_ecrit_coef, m4101_tp_coef);
        load2GradeFromSharedPreferences(m4101_name, m4101_ecrit_note, m4101_tp_note);
        refreshTextView.refresh2coef2grade(m4101_note, m4101_coef, m4101_ecrit_note, m4101_ecrit_coef, m4101_tp_note, m4101_tp_coef);

        load2CoefFromSharedPreferences(m4102_name, m4102_ecrit_coef, m4102_tp_coef);
        load2GradeFromSharedPreferences(m4102_name, m4102_ecrit_note, m4102_tp_note);
        refreshTextView.refresh2coef2grade(m4102_note, m4102_coef, m4102_ecrit_note, m4102_ecrit_coef, m4102_tp_note, m4102_tp_coef);

        load2CoefFromSharedPreferences(m4103_name, m4103_ecrit_coef, m4103_tp_coef);
        load2GradeFromSharedPreferences(m4103_name, m4103_ecrit_note, m4103_tp_note);
        refreshTextView.refresh2coef2grade(m4103_note, m4103_coef, m4103_ecrit_note, m4103_ecrit_coef, m4103_tp_note, m4103_tp_coef);

        load2CoefFromSharedPreferences(m4104_name, m4104_ecrit_coef, m4104_tp_coef);
        load2GradeFromSharedPreferences(m4104_name, m4104_ecrit_note, m4104_tp_note);
        refreshTextView.refresh2coef2grade(m4104_note, m4104_coef, m4104_ecrit_note, m4104_ecrit_coef, m4104_tp_note, m4104_tp_coef);

        load2CoefFromSharedPreferences(m4105_name, m4105_ecrit_coef, m4105_tp_coef);
        load2GradeFromSharedPreferences(m4105_name, m4105_ecrit_note, m4105_tp_note);
        refreshTextView.refresh2coef2grade(m4105_note, m4105_coef, m4105_ecrit_note, m4105_ecrit_coef, m4105_tp_note, m4105_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m4106_name, m4106_tp_coef, m4106_tp_note);
        refreshTextView.refresh1coef1grade(m4106_note, m4106_coef, m4106_tp_note, m4106_tp_coef);

        /**
         * Charge les notes et coef de l'UE42 des SharedPreferences et les affiche
         */
        load2CoefFromSharedPreferences(m4201_name, m4201_ecrit_coef, m4201_tp_coef);
        load2GradeFromSharedPreferences(m4201_name, m4201_ecrit_note, m4201_tp_note);
        refreshTextView.refresh2coef2grade(m4201_note, m4201_coef, m4201_ecrit_note, m4201_ecrit_coef, m4201_tp_note, m4201_tp_coef);

        load2CoefFromSharedPreferences(m4202_name, m4202_ecrit_coef, m4202_tp_coef);
        load2GradeFromSharedPreferences(m4202_name, m4202_ecrit_note, m4202_tp_note);
        refreshTextView.refresh2coef2grade(m4202_note, m4202_coef, m4202_ecrit_note, m4202_ecrit_coef, m4202_tp_note, m4202_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m4203_name, m4203_tp_coef, m4203_tp_note);
        refreshTextView.refresh1coef1grade(m4203_note, m4203_coef, m4203_tp_note, m4203_tp_coef);

        loadCoefAndGradeTPFromSharedPreferences(m4204_name, m4204_tp_coef, m4204_tp_note);
        refreshTextView.refresh1coef1grade(m4204_note, m4204_coef, m4204_tp_note, m4204_tp_coef);

        /**
         * Charge les notes et coef de l'UE43 des SharedPreferences et les affiche
         */
        loadCoefAndGradeTPFromSharedPreferences(m4301_name, m4301_tp_coef, m4301_tp_note);
        refreshTextView.refresh1coef1grade(m4301_note, m4301_coef, m4301_tp_note, m4301_tp_coef);

        /**
         * Calcul des moyennes
         */
        calculerUE41Moyenne();
        calculerUE42Moyenne();
        calculerUE43Moyenne();
        calculerMoyenneGenerale();

        /**
         * Listener sur les EditText et TextView pour changer les notes et coef de l'UE41
         */
        m4101_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4101_note, m4101_coef, m4101_ecrit_note, m4101_ecrit_coef, m4101_tp_note, m4101_tp_coef);
                save2CoefInSharedPreferences(m4101_name, m4101_ecrit_coef, m4101_tp_coef);
                save2GradeInSharedPreferences(m4101_name, m4101_ecrit_note, m4101_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4101_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4101_note, m4101_coef, m4101_ecrit_note, m4101_ecrit_coef, m4101_tp_note, m4101_tp_coef);
                save2CoefInSharedPreferences(m4101_name, m4101_ecrit_coef, m4101_tp_coef);
                save2GradeInSharedPreferences(m4101_name, m4101_ecrit_note, m4101_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4101_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4101_note, m4101_coef, m4101_ecrit_note, m4101_ecrit_coef, m4101_tp_note, m4101_tp_coef);
                save2GradeInSharedPreferences(m4101_name, m4101_ecrit_note, m4101_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4101_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4101_note, m4101_coef, m4101_ecrit_note, m4101_ecrit_coef, m4101_tp_note, m4101_tp_coef);
                save2GradeInSharedPreferences(m4101_name, m4101_ecrit_note, m4101_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m4102_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4102_note, m4102_coef, m4102_ecrit_note, m4102_ecrit_coef, m4102_tp_note, m4102_tp_coef);
                save2CoefInSharedPreferences(m4102_name, m4102_ecrit_coef, m4102_tp_coef);
                save2GradeInSharedPreferences(m4102_name, m4102_ecrit_note, m4102_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4102_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4102_note, m4102_coef, m4102_ecrit_note, m4102_ecrit_coef, m4102_tp_note, m4102_tp_coef);
                save2CoefInSharedPreferences(m4102_name, m4102_ecrit_coef, m4102_tp_coef);
                save2GradeInSharedPreferences(m4102_name, m4102_ecrit_note, m4102_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4102_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4102_note, m4102_coef, m4102_ecrit_note, m4102_ecrit_coef, m4102_tp_note, m4102_tp_coef);
                save2GradeInSharedPreferences(m4102_name, m4102_ecrit_note, m4102_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4102_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4102_note, m4102_coef, m4102_ecrit_note, m4102_ecrit_coef, m4102_tp_note, m4102_tp_coef);
                save2GradeInSharedPreferences(m4102_name, m4102_ecrit_note, m4102_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m4103_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4103_note, m4103_coef, m4103_ecrit_note, m4103_ecrit_coef, m4103_tp_note, m4103_tp_coef);
                save2CoefInSharedPreferences(m4103_name, m4103_ecrit_coef, m4103_tp_coef);
                save2GradeInSharedPreferences(m4103_name, m4103_ecrit_note, m4103_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4103_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4103_note, m4103_coef, m4103_ecrit_note, m4103_ecrit_coef, m4103_tp_note, m4103_tp_coef);
                save2CoefInSharedPreferences(m4103_name, m4103_ecrit_coef, m4103_tp_coef);
                save2GradeInSharedPreferences(m4103_name, m4103_ecrit_note, m4103_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4103_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4103_note, m4103_coef, m4103_ecrit_note, m4103_ecrit_coef, m4103_tp_note, m4103_tp_coef);
                save2GradeInSharedPreferences(m4103_name, m4103_ecrit_note, m4103_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4103_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4103_note, m4103_coef, m4103_ecrit_note, m4103_ecrit_coef, m4103_tp_note, m4103_tp_coef);
                save2GradeInSharedPreferences(m4103_name, m4103_ecrit_note, m4103_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m4104_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4104_note, m4104_coef, m4104_ecrit_note, m4104_ecrit_coef, m4104_tp_note, m4104_tp_coef);
                save2CoefInSharedPreferences(m4104_name, m4104_ecrit_coef, m4104_tp_coef);
                save2GradeInSharedPreferences(m4104_name, m4104_ecrit_note, m4104_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4104_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4104_note, m4104_coef, m4104_ecrit_note, m4104_ecrit_coef, m4104_tp_note, m4104_tp_coef);
                save2CoefInSharedPreferences(m4104_name, m4104_ecrit_coef, m4104_tp_coef);
                save2GradeInSharedPreferences(m4104_name, m4104_ecrit_note, m4104_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4104_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4104_note, m4104_coef, m4104_ecrit_note, m4104_ecrit_coef, m4104_tp_note, m4104_tp_coef);
                save2GradeInSharedPreferences(m4104_name, m4104_ecrit_note, m4104_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4104_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4104_note, m4104_coef, m4104_ecrit_note, m4104_ecrit_coef, m4104_tp_note, m4104_tp_coef);
                save2GradeInSharedPreferences(m4104_name, m4104_ecrit_note, m4104_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m4105_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4105_note, m4105_coef, m4105_ecrit_note, m4105_ecrit_coef, m4105_tp_note, m4105_tp_coef);
                save2CoefInSharedPreferences(m4105_name, m4105_ecrit_coef, m4105_tp_coef);
                save2GradeInSharedPreferences(m4105_name, m4105_ecrit_note, m4105_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4105_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4105_note, m4105_coef, m4105_ecrit_note, m4105_ecrit_coef, m4105_tp_note, m4105_tp_coef);
                save2CoefInSharedPreferences(m4105_name, m4105_ecrit_coef, m4105_tp_coef);
                save2GradeInSharedPreferences(m4105_name, m4105_ecrit_note, m4105_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4105_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4105_note, m4105_coef, m4105_ecrit_note, m4105_ecrit_coef, m4105_tp_note, m4105_tp_coef);
                save2GradeInSharedPreferences(m4105_name, m4105_ecrit_note, m4105_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4105_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4105_note, m4105_coef, m4105_ecrit_note, m4105_ecrit_coef, m4105_tp_note, m4105_tp_coef);
                save2GradeInSharedPreferences(m4105_name, m4105_ecrit_note, m4105_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m4106_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m4106_note, m4106_coef, m4106_tp_note, m4106_tp_coef);
                saveCoefGradeTPInSharedPreferences(m4106_name, m4106_tp_coef, m4106_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4106_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m4106_note, m4106_coef, m4106_tp_note, m4106_tp_coef);
                saveCoefGradeTPInSharedPreferences(m4106_name, m4106_tp_coef, m4106_tp_note);
                calculerUE41Moyenne();
                calculerMoyenneGenerale();
            }
        });

        /**
         * Listener sur les EditText et TextView pour changer les notes et coef de l'UE42
         */
        m4201_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4201_note, m4201_coef, m4201_ecrit_note, m4201_ecrit_coef, m4201_tp_note, m4201_tp_coef);
                save2CoefInSharedPreferences(m4201_name, m4201_ecrit_coef, m4201_tp_coef);
                save2GradeInSharedPreferences(m4201_name, m4201_ecrit_note, m4201_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4201_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4201_note, m4201_coef, m4201_ecrit_note, m4201_ecrit_coef, m4201_tp_note, m4201_tp_coef);
                save2CoefInSharedPreferences(m4201_name, m4201_ecrit_coef, m4201_tp_coef);
                save2GradeInSharedPreferences(m4201_name, m4201_ecrit_note, m4201_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4201_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4201_note, m4201_coef, m4201_ecrit_note, m4201_ecrit_coef, m4201_tp_note, m4201_tp_coef);
                save2GradeInSharedPreferences(m4201_name, m4201_ecrit_note, m4201_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4201_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4201_note, m4201_coef, m4201_ecrit_note, m4201_ecrit_coef, m4201_tp_note, m4201_tp_coef);
                save2GradeInSharedPreferences(m4201_name, m4201_ecrit_note, m4201_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m4202_ecrit_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4202_note, m4202_coef, m4202_ecrit_note, m4202_ecrit_coef, m4202_tp_note, m4202_tp_coef);
                save2CoefInSharedPreferences(m4202_name, m4202_ecrit_coef, m4202_tp_coef);
                save2GradeInSharedPreferences(m4202_name, m4202_ecrit_note, m4202_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4202_tp_coef.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4202_note, m4202_coef, m4202_ecrit_note, m4202_ecrit_coef, m4202_tp_note, m4202_tp_coef);
                save2CoefInSharedPreferences(m4202_name, m4202_ecrit_coef, m4202_tp_coef);
                save2GradeInSharedPreferences(m4202_name, m4202_ecrit_note, m4202_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4202_ecrit_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4202_note, m4202_coef, m4202_ecrit_note, m4202_ecrit_coef, m4202_tp_note, m4202_tp_coef);
                save2GradeInSharedPreferences(m4202_name, m4202_ecrit_note, m4202_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4202_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh2coef2grade(m4202_note, m4202_coef, m4202_ecrit_note, m4202_ecrit_coef, m4202_tp_note, m4202_tp_coef);
                save2GradeInSharedPreferences(m4202_name, m4202_ecrit_note, m4202_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m4203_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m4203_note, m4203_coef, m4203_tp_note, m4203_tp_coef);
                saveCoefGradeTPInSharedPreferences(m4203_name, m4203_tp_coef, m4203_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4203_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m4203_note, m4203_coef, m4203_tp_note, m4203_tp_coef);
                saveCoefGradeTPInSharedPreferences(m4203_name, m4203_tp_coef, m4203_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });

        m4204_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m4204_note, m4204_coef, m4204_tp_note, m4204_tp_coef);
                saveCoefGradeTPInSharedPreferences(m4204_name, m4204_tp_coef, m4204_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4204_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m4204_note, m4204_coef, m4204_tp_note, m4204_tp_coef);
                saveCoefGradeTPInSharedPreferences(m4204_name, m4204_tp_coef, m4204_tp_note);
                calculerUE42Moyenne();
                calculerMoyenneGenerale();
            }
        });

        /**
         * Listener sur les EditText et TextView pour changer les notes et coef de l'UE43
         */
        m4301_tp_coef.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m4301_note, m4301_coef, m4301_tp_note, m4301_tp_coef);
                saveCoefGradeTPInSharedPreferences(m4301_name, m4301_tp_coef, m4301_tp_note);
                calculerUE43Moyenne();
                calculerMoyenneGenerale();
            }
        });
        m4301_tp_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                refreshTextView.refresh1coef1grade(m4301_note, m4301_coef, m4301_tp_note, m4301_tp_coef);
                saveCoefGradeTPInSharedPreferences(m4301_name, m4301_tp_coef, m4301_tp_note);
                calculerUE43Moyenne();
                calculerMoyenneGenerale();
            }
        });

        return root;
    }

    /**
     * Calcul de la moyenne de l'UE41
     */
    public void calculerUE41Moyenne() {
        sommecoefue41 = 0;
        float ue41 = 0;

        for (int i = 0; i < tableau_s4.getChildCount(); i++) {
            TextView coef = tableau_s4.getChildAt(i).findViewWithTag("coef1");
            TextView note = tableau_s4.getChildAt(i).findViewWithTag("note1");
            if (coef == null || note == null) continue;
            DecimalFormat decimalFormat = new DecimalFormat();
            try {
                float coefvalue = decimalFormat.parse(coef.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                float notevalue = decimalFormat.parse(note.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                ue41 += coefvalue * notevalue;
                sommecoefue41 += coefvalue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ue41_moyenne.setText(" " + Math.floor((ue41/sommecoefue41)*100)/100);
    }

    /**
     * Calcul de la moyenne de l'UE42
     */
    public void calculerUE42Moyenne() {
        sommecoefue42 = 0;
        float ue42 = 0;

        for (int i = 0; i < tableau_s4.getChildCount(); i++) {
            TextView coef = tableau_s4.getChildAt(i).findViewWithTag("coef2");
            TextView note = tableau_s4.getChildAt(i).findViewWithTag("note2");
            if (coef == null || note == null) continue;
            DecimalFormat decimalFormat = new DecimalFormat();
            try {
                float coefvalue = decimalFormat.parse(coef.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                float notevalue = decimalFormat.parse(note.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                ue42 += coefvalue * notevalue;
                sommecoefue42 += coefvalue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ue42_moyenne.setText(" " + Math.floor((ue42/sommecoefue42)*100)/100);
    }

    /**
     * Calcul de la moyenne de l'UE43
     */
    public void calculerUE43Moyenne() {
        sommecoefue43 = 0;
        float ue43 = 0;

        for (int i = 0; i < tableau_s4.getChildCount(); i++) {
            TextView coef = tableau_s4.getChildAt(i).findViewWithTag("coef3");
            TextView note = tableau_s4.getChildAt(i).findViewWithTag("note3");
            if (coef == null || note == null) continue;
            DecimalFormat decimalFormat = new DecimalFormat();
            try {
                float coefvalue = decimalFormat.parse(coef.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                float notevalue = decimalFormat.parse(note.getText().toString().replaceAll("[^0-9]", ",")).floatValue();
                ue43 += coefvalue * notevalue;
                sommecoefue43 += coefvalue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ue43_moyenne.setText(" " + Math.floor((ue43/sommecoefue43)*100)/100);
    }

    /**
     * Calcul de la moyenne générale
     */
    public void calculerMoyenneGenerale() {
        float sommeTotalCoef = sommecoefue41 + sommecoefue42 + sommecoefue43;
        float s4 = (Float.parseFloat(ue41_moyenne.getText().toString()) * sommecoefue41) + (Float.parseFloat(ue42_moyenne.getText().toString()) * sommecoefue42) + (Float.parseFloat(ue43_moyenne.getText().toString()) * sommecoefue43);

        moyenne_s4.setText(" " + Math.floor((s4/sommeTotalCoef)*100)/100);
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