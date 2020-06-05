package com.pokemon.pokedex.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.pokemon.pokedex.dto.PokemonDTO;
import com.pokemon.pokedex.dto.converter.PokemonDTOConverter;
import com.pokemon.pokedex.errors.NotMorePage;
import com.pokemon.pokedex.errors.PokemonNotFound;
import com.pokemon.pokedex.model.Pokemon;
import com.pokemon.pokedex.services.PokemonService;
import com.pokemon.pokedex.utilPagination.PaginationLinksUtils;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pokedex")
public class PokemonController {
	// private static final Log LOG = LogFactory.getLog(PokemonController.class);

	@Autowired
	private PokemonService pokemonService;
	private PokemonDTOConverter converter;
	private PaginationLinksUtils paginationLinks;

	/**
	 * GET Request - Lista de pokemons segun su tipo
	 * 
	 * @param type Tipo pokemon
	 * @return Lista Pokemon
	 * @throws PokemonNotFound
	 */
	@GetMapping("/all/{type}")
	public ResponseEntity<?> listAllPokemonsByType(@PathVariable String type) throws PokemonNotFound {
		List<Pokemon> listPk = pokemonService.findAllByType(type);
		if (!listPk.isEmpty()) {
			List<PokemonDTO> dtoList = listPk.stream().map(converter::convertToDTO).collect(Collectors.toList());
			return ResponseEntity.ok().body(dtoList);
		} else {
			throw new PokemonNotFound(PokemonNotFound.LIST_EMPTY);
		}
	}

	/**
	 * GET Rqequest - Lista de TODOS los Pokemons
	 * 
	 * @return
	 * @throws PokemonNotFound
	 * @throws NotMorePage
	 */
	@GetMapping("/all")
	public ResponseEntity<?> listAllPokemons(@PageableDefault(size = 10, page = 0) Pageable pageable,
			HttpServletRequest request) throws PokemonNotFound, NotMorePage {
		Page<Pokemon> listPk = pokemonService.findAll(pageable);

		if (!listPk.isEmpty()) {
			Page<PokemonDTO> dtoList = listPk.map(converter::convertToDTO);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

			// return ResponseEntity.ok().body(listPk);

			return ResponseEntity.ok().header("link", paginationLinks.createLinkHeader(dtoList, uriBuilder))
					.body(dtoList);
		} else {
			if (listPk.getTotalPages() < pageable.getPageNumber()) {
				throw new NotMorePage();
			} else {
				throw new PokemonNotFound(PokemonNotFound.LIST_EMPTY);
			}

		}
	}

	/**
	 * GET Request - Lista de TODOS los Pokemons de la generacion deseada
	 * 
	 * @return
	 * @throws PokemonNotFound
	 */
	@GetMapping("/all/generation/{gen}")
	public ResponseEntity<?> listAllPokemonsByGeneration(@PathVariable("gen") long gen)
			throws PokemonNotFound, NotMorePage {
		List<Pokemon> listPk = pokemonService.findAllByGeneration(gen);

		if (!listPk.isEmpty()) {
			List<PokemonDTO> dtoList = listPk.stream().map(converter::convertToDTO).collect(Collectors.toList());

			return ResponseEntity.ok().body(dtoList);

		} else {

			throw new PokemonNotFound(PokemonNotFound.NOT_FOUND_GENERATION);

		}
	}

	/**
	 * GET Request - Lista de TODOS los Pokemons (ordenados por ataque)
	 * 
	 * @return
	 * @throws PokemonNotFound
	 */
	@GetMapping("/all-order-attack")
	public ResponseEntity<?> listAllPokemonsOrderAttack() throws PokemonNotFound {
		List<Pokemon> listPk = pokemonService.findAllOrderAttack();
		if (!listPk.isEmpty()) {
			List<PokemonDTO> dtoList = listPk.stream().map(converter::convertToDTO).collect(Collectors.toList());
			return ResponseEntity.ok().body(dtoList);
		} else {
			throw new PokemonNotFound(PokemonNotFound.LIST_EMPTY);
		}
	}

	/**
	 * GET Request - Pokemon con la ID pedida
	 * 
	 * @param id
	 * @return
	 * @throws PokemonNotFound
	 */
	@GetMapping("/id/{id}")
	public ResponseEntity<?> pokemonByID(@PathVariable long id) throws PokemonNotFound {
		Pokemon pokemon = pokemonService.findById(id).orElse(null);

		if (pokemon != null) {
			return ResponseEntity.ok().body(pokemon);
		} else {
			throw new PokemonNotFound(PokemonNotFound.ID_NOT_FOUND);
		}
	}
	public void reset() {
		
	}
	/**
	 * GET Request - Pokemon con el nombre pedido
	 * 
	 * @param name
	 * @return
	 * @throws PokemonNotFound
	 */
	@GetMapping("/name/{name}")
	public ResponseEntity<?> pokemonByName(@PathVariable String name) throws PokemonNotFound {
		Pokemon pokemon = pokemonService.findByName(name);

		if (pokemon != null) {
			return ResponseEntity.ok().body(pokemon);
		} else {
			throw new PokemonNotFound(PokemonNotFound.NAME_NOT_FOUND);
		}
	}
}
