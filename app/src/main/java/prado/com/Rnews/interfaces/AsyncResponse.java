package prado.com.Rnews.interfaces;

import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;

/**
 * Created by Prado on 14/08/2016.
 */

public interface AsyncResponse {
    void processFinish(Listing<Submission> output);
}
