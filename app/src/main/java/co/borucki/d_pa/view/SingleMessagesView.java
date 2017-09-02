package co.borucki.d_pa.view;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.borucki.d_pa.R;
import co.borucki.d_pa.model.Message;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.MessageRepository;
import co.borucki.d_pa.repository.MessageRepositoryImpl;
import co.borucki.d_pa.repository.UserRepository;
import co.borucki.d_pa.repository.UserRepositoryImpl;

public class SingleMessagesView extends AppCompatActivity {
    MessageRepository mMessageRepository = MessageRepositoryImpl.getInstance();
    UserRepository mUserRepository = UserRepositoryImpl.getInstance();
    DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();
    @BindView(R.id.single_message_view_from)
    TextView mFrom;
    @BindView(R.id.single_message_view_date)
    TextView mDate;
    @BindView(R.id.single_message_view_contents)
    TextView mContents;
    private boolean changedReadMessageStatus = false;
    private Handler handler;
    private Runnable runnable;
    private Message message;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_message_view);
        ButterKnife.bind(this);
        int messageId = getIntent().getIntExtra("message", 0);
        message = mMessageRepository.getMessageById(messageId);

        if (message.getUserId().equals(mDpaRepository.getSignedUser())) {
            mFrom.setText(R.string.SingleMessageViewFrom);
        } else {

            mFrom.setText(mUserRepository.getUserById(message.getUserId()).getSurname()
                    + " "
                    + mUserRepository.getUserById(message.getUserId()).getName());
        }

        mDate.setText(showDateOrTime(message.getDate()));

        mContents.setText(message.getContents());

        handler = new Handler();
        handler.postDelayed(runnable, 5000);

        runnable = new Runnable() {

            @Override
            public void run() {
                if (!changedReadMessageStatus) {
                    message.setRead(true);
                    mMessageRepository.updateMessage(message);
                    changedReadMessageStatus = true;
                }
            }

        };
    }

    String showDateOrTime(String date) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(calendar.getTime());
        return date.substring(0, 10).equals(formattedDate) ? date.substring(11, 19) : date.substring(0, 10);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }


    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 5000);
    }

    @OnClick(R.id.single_message_view_delete)
    public void deleteMessage() {
handler.removeCallbacks(runnable);
        mMessageRepository.deleteMessage(message);
        finish();
    }
}
