package net.minasamy.reactiveprogrammingdemo.adapter;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import net.minasamy.reactiveprogrammingdemo.R;
import net.minasamy.reactiveprogrammingdemo.databinding.StackExchangeUserItemBinding;
import net.minasamy.reactiveprogrammingdemo.model.StackExchangeUser;
import net.minasamy.reactiveprogrammingdemo.viewmodel.StackExchangeUserViewModel;

import java.util.List;

/**
 * Created by Mina.Samy on 9/19/2016.
 */
public class StackExchangeUsersAdapter extends RecyclerView.Adapter<StackExchangeUsersAdapter.UserViewHolder> {

    private List<StackExchangeUser> mUsers;

    public StackExchangeUsersAdapter(List<StackExchangeUser> users) {
        this.mUsers = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        StackExchangeUserItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.stack_exchange_user_item
                , parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.setUser(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private StackExchangeUserItemBinding mBinding;

        public UserViewHolder(StackExchangeUserItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void setUser(StackExchangeUser user) {
            mBinding.setViewModel(new StackExchangeUserViewModel(user));
            Glide.with(mBinding.userProfileImage.getContext())
                    .load(user.profileImageUrl)
                    .asBitmap()
                    .centerCrop()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            RoundedBitmapDrawable img =
                                    RoundedBitmapDrawableFactory.create(mBinding.userProfileImage.getContext().getResources()
                                            , resource);
                            img.setCornerRadius((float)resource.getWidth()/2.0f);
                            mBinding.userProfileImage.setImageDrawable(img);
                        }
                    });
        }
    }
}
