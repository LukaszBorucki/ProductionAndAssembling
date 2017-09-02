package co.borucki.d_pa.adapter;


import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.d_pa.R;
import co.borucki.d_pa.model.Message;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.UserRepository;
import co.borucki.d_pa.repository.UserRepositoryImpl;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private UserRepository mUserRepository = UserRepositoryImpl.getInstance();
    private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();
    private final LayoutInflater mLayoutInflater;
    private final List<Message> mData = new ArrayList<>();
    private View.OnLongClickListener mOnLongClickListener;
    private View.OnClickListener mOnClickListener;

    public MessageAdapter(Context context) {

        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.fragment_message_single_row, parent, false);

        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();


        if (message.getUserId().equals(mDpaRepository.getSignedUser())) {
            holder.mFrom.setText(R.string.SingleMessageViewFrom);
        } else {

            holder.mFrom.setText(mUserRepository.getUserById(message.getUserId()).getSurname()
                    + " "
                    + mUserRepository.getUserById(message.getUserId()).getName());
        }
        holder.mContents.setText(message.getContents());

        holder.mDate.setText(showDateOrTime(message.getDate()));
        if (!message.isRead()) {
            holder.mBody.setBackground(ResourcesCompat
                    .getDrawable(holder.mBody.getResources(), R.drawable.border_unread, null));
        }
        else {
            holder.mBody.setBackground(ResourcesCompat
                    .getDrawable(holder.mBody.getResources(), R.drawable.border, null));

        }
        holder.itemView.setTag(message);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                return mOnLongClickListener.onLongClick(v);
            }
        });

        holder.itemView.setOnClickListener(mOnClickListener);

    }

    private String showDateOrTime(String date) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(calendar.getTime());
        return date.substring(0, 10).equals(formattedDate) ? date.substring(11, 16) : date.substring(0, 10);
    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<Message> messageList) {
        mData.clear();
        mData.addAll(messageList);
        notifyDataSetChanged();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fragment_message_single_row_contents)
        TextView mContents;

        @BindView(R.id.fragment_message_single_row_from)
        TextView mFrom;
        @BindView(R.id.fragment_message_single_row_date)
        TextView mDate;
        @BindView(R.id.fragment_message_single_row_body)
        LinearLayout mBody;


        public MessageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        mOnLongClickListener = onLongClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }
}