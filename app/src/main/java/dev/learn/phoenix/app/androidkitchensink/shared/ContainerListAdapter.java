package dev.learn.phoenix.app.androidkitchensink.shared;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import dev.learn.phoenix.app.androidkitchensink.R;

/**
 * Created by sudharti on 7/26/17.
 */

public class ContainerListAdapter extends ArrayAdapter<ContainerListItem> {
    private List<ContainerListItem> mContainerListItems;
    private Context mContext;

    public ContainerListAdapter(Context context, List<ContainerListItem> containerListItems) {
        super(context, 0, containerListItems);
        this.mContext = context;
        this.mContainerListItems = containerListItems;
    }

    @Override
    public int getItemViewType(int position) {
        return mContainerListItems.get(position).isHeading() ? 0 : 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Nullable
    @Override
    public ContainerListItem getItem(int position) {
        return mContainerListItems.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        int rowType = getItemViewType(position);

        if (convertView == null) {
            viewHolder = new ViewHolder();

            switch (rowType) {
                case 0:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_heading_container_list, null);
                    viewHolder.mTextView = (TextView) convertView.findViewById(R.id.text_view_item_heading);
                    break;
                case 1:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_container_list, null);
                    viewHolder.mTextView = (TextView) convertView.findViewById(R.id.text_view_item_text);
                    break;
            }

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mTextView.setText(getItem(position).getText());
        return convertView;
    }

    protected static class ViewHolder {
        private TextView mTextView;
    }
}
