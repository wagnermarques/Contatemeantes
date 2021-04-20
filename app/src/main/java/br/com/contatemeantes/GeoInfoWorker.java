package br.com.contatemeantes;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class GeoInfoWorker extends Worker {

        public GeoInfoWorker(
                @NonNull Context context,
                @NonNull WorkerParameters params) {
            super(context, params);
        }

        @Override
        public Result doWork() {

            // Do the work here--in this case, upload the images.
            Log.w("%*%*%*%*%*%","public Result doWork() {...");
            FirebaseFeatures.SaveDocument("Users");
            // Indicate whether the work finished successfully with the Result
            return Result.success();
        }
    }
