package cl.desafiolatam.superheroes.modelo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HeroesRespuesta{

	@SerializedName("HeroesRespuesta")
	private List<HeroesRespuestaItem> heroesRespuesta;

	public void setHeroesRespuesta(List<HeroesRespuestaItem> heroesRespuesta){
		this.heroesRespuesta = heroesRespuesta;
	}

	public List<HeroesRespuestaItem> getHeroesRespuesta(){
		return heroesRespuesta;
	}

	@Override
 	public String toString(){
		return 
			"HeroesRespuesta{" + 
			"heroesRespuesta = '" + heroesRespuesta + '\'' + 
			"}";
		}
}