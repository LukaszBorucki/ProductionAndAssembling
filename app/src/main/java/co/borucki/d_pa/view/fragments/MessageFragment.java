package co.borucki.d_pa.view.fragments;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.d_pa.DTO.MessageDTO;
import co.borucki.d_pa.DTO.mappers.Mapper;
import co.borucki.d_pa.MyDevice;
import co.borucki.d_pa.R;
import co.borucki.d_pa.adapter.MessageAdapter;
import co.borucki.d_pa.model.Message;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.MessageRepository;
import co.borucki.d_pa.repository.MessageRepositoryImpl;
import co.borucki.d_pa.view.SingleMessagesView;


public class MessageFragment extends Fragment {
    private static final long REFRESH_TIME = 120000;
    private RecyclerView mRecyclerView;
    private MessageAdapter mMessageAdapter;
    private MessageRepository mMessageRepository = MessageRepositoryImpl.getInstance();
    private TextView onNotReadMessagesButtonClick;
    private TextView onAllMessagesButtonClick;
    private boolean allMessages = false;

    public MessageFragment() {
    }

    public static MessageFragment newInstance() {

        return new MessageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        onNotReadMessagesButtonClick = (TextView) view.findViewById(R.id.fragment_message_not_read);
        onAllMessagesButtonClick = (TextView) view.findViewById(R.id.fragment_message_all);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.experience_fragment_list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mMessageAdapter = new MessageAdapter(getActivity());
        mRecyclerView.setAdapter(mMessageAdapter);
        loadData();
        mMessageAdapter.setOnLongClickListener(mOnLongClickLisner);
        mMessageAdapter.setOnClickListener(mOnClickLisner);
        onAllMessagesButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allMessages = true;
                onAllMessagesButtonClick.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.border_small_button_selected));
                onNotReadMessagesButtonClick.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.border_small_button));

                loadData();
            }
        });
        onNotReadMessagesButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allMessages = false;
                onAllMessagesButtonClick.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.border_small_button));
                onNotReadMessagesButtonClick.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.border_small_button_selected));
                loadData();

            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }, REFRESH_TIME);
    }

    private void loadData() {

        if (MyDevice.isOnLine(getActivity())) {
            new GetMessages().execute();
        }
    }

    private class GetMessages extends AsyncTask<String, Void, List<MessageDTO>> {
        private MessageRepository mMessageRepository = MessageRepositoryImpl.getInstance();
        private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();

        private GetMessages() {
        }

        @Override
        protected List<MessageDTO> doInBackground(String... params) {
            String link = "http://www.diamon.pl/api/getAllMessage/?DEVICE="
                    + mDpaRepository.getDeviceId()
                    + "&user="
                    + mDpaRepository.getSignedUser()
                    + "&pass="
                    + mDpaRepository.getSignedUserPassword()
                    + "&startFrom="
                    + mDpaRepository.getLastMessageIndex();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            return Arrays.asList(restTemplate.getForObject(link, MessageDTO[].class));
        }

        @Override
        protected void onPostExecute(List<MessageDTO> messageDTOs) {
            mMessageRepository.saveMessage(Mapper.fromMessageDTOToMessage(messageDTOs));
            if (mMessageRepository.getLastIndexOfMessage() > mDpaRepository.getLastMessageIndex()) {
                mDpaRepository.setLastMessageIndex(mMessageRepository.getLastIndexOfMessage());
            }


            if (allMessages) {
                mMessageAdapter.setData(mMessageRepository.getAllMessage());
            } else {
                mMessageAdapter.setData(mMessageRepository.getUnreadMessage());
            }
        }
    }


    private final View.OnLongClickListener mOnLongClickLisner =
            new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(final View v) {
                    Message message = (Message) v.getTag();
                    message.setRead(false);
                    mMessageRepository.updateMessage(message);
                    mMessageAdapter.notifyDataSetChanged();
                    Log.d("TAG", message.getDate());
//                    showAskDialog(visitor);
                    return true;
                }

            };

    private final View.OnClickListener mOnClickLisner =
            new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    Message message = (Message) v.getTag();
                    Intent intent = new Intent(getContext(), SingleMessagesView.class);
                    intent.putExtra("message", message.getId());
                    startActivity(intent);
                }

            };

}
