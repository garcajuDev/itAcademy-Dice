package game.dice.com.dicegameapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayersHolder> {

    ArrayList<String> playersList;

    public PlayersAdapter(ArrayList<String> playersList){
        this.playersList = playersList;
    }

    @Override
    public PlayersHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_players,null , false);
        return new PlayersHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayersHolder holder, int i) {
        holder.name.setText(this.playersList.get(i));
        holder.photo.setImageResource(R.drawable.avatar);
    }

    @Override
    public int getItemCount() {
        return playersList.size();
    }

    public class PlayersHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView photo;
        public PlayersHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtPlayerName);
            photo = itemView.findViewById(R.id.imgPhotoUser);
        }
    }
}
