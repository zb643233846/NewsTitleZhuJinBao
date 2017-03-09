package modle;

import java.util.ArrayList;

/**
 * Created by LX-PC on 2017/2/24.
 */

public interface CallbackNewsData<T> {
    void success(ArrayList<T> newsContents);
}
