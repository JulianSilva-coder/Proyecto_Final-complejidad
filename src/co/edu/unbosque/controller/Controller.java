package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import co.edu.unbosque.model.Rating;
import co.edu.unbosque.view.Ventana_Principal;
import co.edu.unbosque.view.Vista;

public class Controller {
	public Ventana_Principal ventana;
	int N;
	public Controller() {
		ventana = new Ventana_Principal();
		Vista vista = new Vista();
		int equipos = Integer.parseInt(vista.scanS("Número de equipos"));
		int arbitros = Integer.parseInt(vista.scanS("Número de arbitros"));
		N = equipos;
		while(arbitros<=equipos/2) {
			arbitros = Integer.parseInt(vista.scanS("El valor no es mayor a la mitad de los equipos"));
		}
		int prefer[][] = new int[equipos*2][equipos];
		for(int a = 0;a<equipos*2;a++) {
			for(int b = 0;b<equipos;b++) {
				if(a>=equipos) {
					prefer[a][b]=b;
				}
				else{
					if(b<arbitros) {
					prefer[a][b]=equipos-arbitros;
					}
					else {
						prefer[a][b]=1;
					}
				}
			}
		}
		for(int a = 0;a<equipos;a++) {
			ArrayList<Rating> rating = new ArrayList<Rating>();
			int[] seleccion = new int[arbitros];
			for(int b=0;b<arbitros;b++) {
				rating.add(new Rating(b, a, Integer.parseInt(vista.scanS("Cual es el rating del equipo "+a+" del arbitro "+b))));
			}
			Collections.sort(rating);
			for(int c = 0;c<arbitros;c++) {
			prefer[a][c]= prefer[a][c]+rating.get(c).getArbitro();
			}
		}	
		for(int a = 0;a<equipos*2;a++) {
			int c=-1;
			for(int b = arbitros;b<equipos&&a<equipos;b++) {
				prefer[a][b] = prefer[a][b]+c;
				c++;
			}
		}
		for(int a = 0;a<equipos*2;a++) {
			for(int b = 0;b<equipos;b++) {
				if(a<equipos) {
					prefer[a][b]=prefer[a][b]+N;
				}
			}
		}	
		for(int a = 0;a<equipos*2;a++) {
			for(int b = 0;b<equipos;b++) {
				System.out.print(prefer[a][b]+", ");
			}
			System.out.println("");
		}	
            preferencias(prefer, equipos-arbitros);
	}
	 
	boolean preferencia(int prefer[][], int w, int m, int m1)
	{
	    for (int i = 0; i < N; i++)
	    {

	        if (prefer[w][i] == m1)
	            return true;

	        if (prefer[w][i] == m)
	        return false;
	    }
	    return false;
	}
	void preferencias(int prefer[][], int tam)
	{
	    int wPartner[] = new int[N];
	 
	    boolean mFree[] = new boolean[N];
	 
	    Arrays.fill(wPartner, -1);
	    int freeCount = N;
	 
	    while (freeCount > 0)
	    {
	        int m;
	        for (m = 0; m < N; m++)
	            if (mFree[m] == false)
	                break;
	 
	        for (int i = 0; i < N &&
	                        mFree[m] == false; i++)
	        {
	            int w = prefer[m][i];
	 
	            if (wPartner[w - N] == -1)
	            {
	                wPartner[w - N] = m;
	                mFree[m] = true;
	                freeCount--;
	            }
	 
	            else
	            {
	                int m1 = wPartner[w - N];
	 

	                if (preferencia(prefer, w, m, m1) == false)
	                {
	                    wPartner[w - N] = m;
	                    mFree[m] = true;
	                    mFree[m1] = false;
	                }
	            } 
	        }
	          
	    }
	 
	System.out.println("Equipo Arbitro");
	for (int i = tam; i < N; i++)
	{
	    System.out.print(" ");
	    System.out.println(i-tam  + "     " +
	                           wPartner[i]);
	}
	}
}
