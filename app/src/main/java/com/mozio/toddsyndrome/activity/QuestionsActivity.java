package com.mozio.toddsyndrome.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.mozio.toddsyndrome.R;
import com.mozio.toddsyndrome.model.Patient;
import com.mozio.toddsyndrome.logic.ToddSyndromeModel;

public class QuestionsActivity extends AppCompatActivity {

    private Button buttonFinish;
    private EditText editTextName;
    private EditText editTextAge;
    private RadioGroup radioGroupGender;
    private RadioGroup radioGroupMigraines;
    private RadioGroup radioGroupDrugs;
    private Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        getViews();
        getViewsImpl();
    }

    private void getViews() {

        buttonFinish = (Button) findViewById(R.id.buttonFinish);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        radioGroupMigraines = (RadioGroup) findViewById(R.id.radioGroupMigranes);
        radioGroupDrugs = (RadioGroup) findViewById(R.id.radioGroupDrugs);
    }

    private void getViewsImpl() {
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!createPatientWithFields()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(QuestionsActivity.this);
                    builder.setTitle("Error");
                    builder.setMessage("Fill in the fields correctly please.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                    return;

                }
                patient.save();
                double probability = ToddSyndromeModel.calculateProbability(patient);
                Intent startQuestionsIntent = new Intent(getBaseContext(), ResultActivity.class);
                startQuestionsIntent.putExtra("probability", probability);
                startActivity(startQuestionsIntent);
            }
        });
    }

    private boolean createPatientWithFields() {

        patient = new Patient();

        //name
        String name = editTextName.getText().toString();
        if (name == null || name.equals("")) return false;
        patient.setName(editTextName.getText().toString());

        //age
        int age = Integer.parseInt(editTextAge.getText().toString());
        if (age == 0) return false;
        patient.setAge(age);

        //gender
        int radioButtonGenderId = radioGroupGender.getCheckedRadioButtonId();
        if (radioButtonGenderId == -1) return false;
        int genderIndex = radioGroupGender.indexOfChild(radioGroupGender.findViewById(radioButtonGenderId));
        String gender = (genderIndex == 0) ? "Male" : "Female";
        patient.setGender(gender);

        //migraines
        int radioButtonMigrainesId = radioGroupMigraines.getCheckedRadioButtonId();
        if (radioButtonMigrainesId == -1) return false;
        int migrainesIndex = radioGroupMigraines.indexOfChild(radioGroupMigraines.findViewById(radioButtonMigrainesId));
        boolean migraines = (migrainesIndex == 0);
        patient.setMigraines(migraines);

        //drugs
        int radioButtonDrugsId = radioGroupDrugs.getCheckedRadioButtonId();
        if (radioButtonDrugsId == -1) return false;
        int drugsIndex = radioGroupDrugs.indexOfChild(radioGroupDrugs.findViewById(radioButtonDrugsId));
        boolean drugs = (drugsIndex == 0);
        patient.setUsedDrugs(drugs);

        return true;
    }

}
