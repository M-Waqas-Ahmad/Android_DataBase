package pk.talmeez.muhaamad500.studentmanagementapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentRecycleViewAdapter extends RecyclerView.Adapter<StudentRecycleViewAdapter.MyViewHolder> {

    Context context;
    List<StudenModule> student ;
    String stdName  , stdFatherName , stdRno;
    float stdFee;


    public OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener{
        void OnItem(int position);
    }

    public  StudentRecycleViewAdapter(List<StudenModule> s) {
        Log.d("RV Adapter" , "in RV adapter constructor");
        this.student = s;
        Log.d("RV Adapter" , "in RV adapter constructor object created ");

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("RV Adapter" , "in OnCreate method");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row_designe , parent , false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        Log.d("RV Adapter" , "layout converted in view and returning view holder ");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Log.d("RV Adapter" , "onBinding ");
        stdName = student.get(position).getStdName();
        stdFatherName = student.get(position).getStdFatherName();
        stdRno = student.get(position).getStdRollNumber();
        stdFee = student.get(position).getStdTotalFee();
        Log.d("RV Adapter" , "in onBinding data from list saved in variables");

        holder.name.setText(stdName);
        holder.rno.setText(stdRno);

        Log.d("RV Adapter" , "data has be set to view ");



    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name , rno;
        ConstraintLayout rootLayout ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvRvStdName);
            rno = itemView.findViewById(R.id.tvRvStdRollNumber);





            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener != null){
                        int position = getAdapterPosition();
                        if(position >= 0){
                            onItemClickListener.OnItem(position);
                        }
                    }

                }
            });


        }
    }
}
