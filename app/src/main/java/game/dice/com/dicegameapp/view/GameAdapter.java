package game.dice.com.dicegameapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameHolder> {

    private ArrayList<String> gameList;

    public GameAdapter(ArrayList<String> gameList) {
        this.gameList = gameList;
    }

    @Override
    public GameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game_player,null , false);

        return new GameHolder(view);
    }

    @Override
    public void onBindViewHolder(GameHolder holder, int i) {
        holder.result.setText(this.gameList.get(i));
    }

    @Override
    public int getItemCount() { return gameList.size();}

    public class GameHolder extends RecyclerView.ViewHolder {

        TextView result;

        public GameHolder(View itemView) {
            super(itemView);
            result = itemView.findViewById(R.id.txtGameResult);
        }
    }
}
