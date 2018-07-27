package view.grid.list.fruits.examples.com.fruits.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import view.grid.list.fruits.examples.com.fruits.R;
import view.grid.list.fruits.examples.com.fruits.models.Fruit;

public class FruitAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Fruit> list;

    public FruitAdapter(Context context, int layout, List<Fruit> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if(convertView == null){
            //Solo si es nulo, es decir, la primera vez en ser renderizado, inflamos
            //y adjuntamos las referencias del layout en una nueva instancia de nuestro
            //ViewHolder, y lo insertamos dentro del convertView, para reciclar su uso
            convertView = LayoutInflater.from(context).inflate(this.layout, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewName);
            holder.origin = (TextView) convertView.findViewById(R.id.textViewOrigin);
            holder.icon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
            convertView.setTag(holder);
        }else{
            // Obtenemos la referencia que posteriormente pusimos dentro del convertView
            // Y así, reciclamos su uso sin necesidad de buscar de nuevo, referencias con FindViewById
            holder = (ViewHolder) convertView.getTag();
        }

        //Capturo el item como un objeto y se lo paso al currentFruit que a su vez es la instancia de nuestro modelo
        final Fruit currentFruit = (Fruit) getItem(position);

        holder.name.setText(currentFruit.getName());
        holder.origin.setText(currentFruit.getOrigin());
        holder.icon.setImageResource(currentFruit.getIcon());

        return convertView;
    }

    static class ViewHolder {
        private TextView name;
        private TextView origin;
        private ImageView icon;
    }
}
