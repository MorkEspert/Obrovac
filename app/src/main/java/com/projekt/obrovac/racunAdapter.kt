package com.projekt.obrovac

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projekt.obrovac.databinding.RacunItemBinding

class racunAdapter(
    private val racunList:ArrayList<racun>,
    private val th: Context
):RecyclerView.Adapter<racunAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): racunAdapter.ViewHolder {
        val z= RacunItemBinding.inflate(LayoutInflater.from(th),parent, false)
        return ViewHolder(z)
    }

    override fun onBindViewHolder(holder: racunAdapter.ViewHolder, position: Int){
        holder.bindItem(racunList[position], th)
    }

    override fun getItemCount(): Int {
        return racunList.size
    }

    class ViewHolder(private val itemBinding: RacunItemBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(racun: racun, th: Context){
            itemBinding.id.text=racun.id.toString()
            itemBinding.brRacuna1.text=racun.brRacuna
            itemBinding.stanje1.text=racun.stanje
            itemBinding.korisnikR1.text=racun.korisnikR
            itemBinding.datOtvaranja1.text=racun.datOtvaranja

        }
    }
}
