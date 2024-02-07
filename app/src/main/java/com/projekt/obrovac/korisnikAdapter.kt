package com.projekt.obrovac

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projekt.obrovac.databinding.KorisnikItemBinding


class korisnikAdapter(
    private val korisnikList: ArrayList<korisnik>,
    private val th: MainActivity
) : RecyclerView.Adapter<korisnikAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = KorisnikItemBinding.inflate(LayoutInflater.from(th), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(korisnikList[position], th)
    }

    override fun getItemCount(): Int {
        return korisnikList.size
    }

    class ViewHolder(private val itemBinding: KorisnikItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(korisnik: korisnik, th: MainActivity) {
            itemBinding.id.text = korisnik.id.toString()
            itemBinding.ime1.text = korisnik.ime
            itemBinding.prezime1.text = korisnik.prezime
            itemBinding.oib1.text = korisnik.oib
            itemBinding.datRodenja1.text = korisnik.datRodenja
        }
    }
}

