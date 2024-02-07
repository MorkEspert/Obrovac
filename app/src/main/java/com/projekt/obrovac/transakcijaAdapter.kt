package com.projekt.obrovac

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projekt.obrovac.databinding.TransakcijaItemBinding


class transakcijaAdapter(
    private val transakcijaList: ArrayList<transakcija>,
    private val th: Context
):RecyclerView.Adapter<transakcijaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): transakcijaAdapter.ViewHolder {
        val x= TransakcijaItemBinding.inflate(LayoutInflater.from(th),parent, false)
        return ViewHolder(x)
    }

    override fun onBindViewHolder(holder: transakcijaAdapter.ViewHolder, position: Int){
        holder.bindItem(transakcijaList[position], th)
    }

    override fun getItemCount(): Int {
        return transakcijaList.size
    }

    class ViewHolder(private val itemBinding: TransakcijaItemBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(transakcija: transakcija, th: Context){
            itemBinding.id.text=transakcija.id.toString()
            itemBinding.korisnikT1.text=transakcija.korisnikT
            itemBinding.racunT1.text=transakcija.racunT
            itemBinding.datTransakcije1.text=transakcija.datTransakcije
            itemBinding.iznos1.text=transakcija.iznos

        }
    }
}
