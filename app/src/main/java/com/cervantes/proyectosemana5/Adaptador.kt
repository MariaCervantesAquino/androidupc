package com.cervantes.proyectosemana5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador: RecyclerView.Adapter<Adaptador.MiViewHolder>() {

    private var listaPersonas = ArrayList<Persona>()

    fun agregarPersonas (personas: ArrayList<Persona>){
        listaPersonas = personas
    }
    class MiViewHolder (var view: View):RecyclerView.ViewHolder(view) {
        private var filaNombres = view.findViewById<TextView>(R.id.filaNombres)
        private var filaDni = view.findViewById<TextView>(R.id.filaDni)
        private var filaCor = view.findViewById<TextView>(R.id.filaCorreo)

        fun rellenarFila(persona: Persona){
        filaNombres.text = persona.per_nom+" "+persona.per_ape
        filaDni.text = persona.per_dni
        filaCor.text = persona.per_cor
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=MiViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.fila,parent,false)

    )

    override fun onBindViewHolder(holder: Adaptador.MiViewHolder, position: Int) {
        val personaItem=listaPersonas[position]
        holder.rellenarFila(personaItem)
    }

    override fun getItemCount(): Int {
        return listaPersonas.size
    }

}