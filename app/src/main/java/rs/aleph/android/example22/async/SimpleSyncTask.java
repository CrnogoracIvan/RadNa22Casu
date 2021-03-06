package rs.aleph.android.example22.async;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import static rs.aleph.android.example22.tools.ReviewerTools.getConnectionType;

/**
 * Created by milossimic on 10/22/16.
 * AsyncTask klasa prima tri parametra prilikom specijalizacije
 * Korisnici sami definisu tip u zavisnosti od posla koji zele da obave.
 *
 * Prvi argument predstavlja ulazne parametre, ono so zelimo
 * da posaljemo zadatku. Recimo ime fajla koji zelimo da skinemo
 *
 * Drugi argument je indikator kako ce se meriti progres. Koliko je posla
 * zavrseno i koliko je opsla ostalo.
 *
 * Treci parametar je povratna vrednost, tj sta ce metoda doInBackground
 * vratiti kao poratnu vrednost metodi onPostExecute
 */
public class SimpleSyncTask extends AsyncTask<Integer, Void, Integer>{

    private Context context;
   // private Integer statusKonekcije;

    public SimpleSyncTask(Context context) {
        this.context = context;
    }

    /**
     * Metoda se poziva pre samog starta pozadinskog zadatka
     * Sve pripreme odraditi u ovoj metodi, ako ih ima.
     */
    @Override
    protected void onPreExecute() {
    }

    /**
     * Posao koji se odvija u pozadini, ne blokira glavnu nit aplikacije.
     * Sav posao koji dugo traje izvrsavati unutar ove metode.
     */
    @Override
    protected Integer doInBackground(Integer... params) {
        try {
            //simulacija posla koji se obavlja u pozadini i traje duze vreme
           // statusKonekcije = params[0];
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return params[0];
    }

    /**
     *
     * Kada se posao koji se odvija u pozadini zavrsi, poziva se ova metoda
     * Ako je potrebno osloboditi resurse ili obrisati elemente koji vise ne trebaju.
     */
    @Override
    protected void onPostExecute(Integer products) {
        Toast.makeText(context, "Sync done with " + getConnectionType(products), Toast.LENGTH_SHORT).show();
    }
}
