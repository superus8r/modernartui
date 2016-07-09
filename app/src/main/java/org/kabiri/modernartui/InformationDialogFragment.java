package org.kabiri.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Ali Kabiri on 7/8/2016.
 * Find me here: ali@kabiri.org
 */
public class InformationDialogFragment extends DialogFragment {

    public static final String TAG = "InformationDialogFragment";
    static private final String URL = "http://www.moma.org";

    public static InformationDialogFragment newInstance() {

        return new InformationDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(R.string.more_info_dialog_title)
                .setMessage(R.string.more_info_dialog_msg)
                .setPositiveButton(R.string.visit_moma, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // open MOMA website in browser.

                        // create the base intent which contains the url.
                        Intent baseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                        // Create a chooser intent, for choosing which Activity
                        // will carry out the view.
                        Intent chooserIntent = Intent.createChooser(baseIntent, getResources().getString(R.string.chooser_text));
                        // Start the chooser Activity, using the chooser intent
                        startActivity(chooserIntent);
                    }
                })
                .setNegativeButton(R.string.not_now, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // dismiss the dialog.
                        dismiss();
                    }
                })
                .create();
    }
}
