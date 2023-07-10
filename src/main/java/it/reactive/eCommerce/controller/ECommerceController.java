package it.reactive.eCommerce.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.reactive.eCommerce.dto.ProdottoDTO;
import it.reactive.eCommerce.model.Utenti;
import it.reactive.eCommerce.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "eCommerce", produces = {MediaType.APPLICATION_JSON_VALUE, "application/json"})
public class ECommerceController {

    @Autowired
    ECommerceService service;

    @ApiOperation(value = "Recupera tutti i prodotti", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK")}
    )
    @GetMapping(value = "/ottieniListaProdotti")
    public ResponseEntity<List<ProdottoDTO>> ottieniListaProdotti(){
        return ResponseEntity.ok(service.ottieniListaProdotti());
    }

    @ApiOperation(value = "Recupera prodotto in dettaglio dal suo id", response = ProdottoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK")}
    )
    @GetMapping(value = "/ottieniProdottoDettaglio")
    public ResponseEntity<ProdottoDTO> ottieniProdottoDettaglio(@RequestParam Long idProdotto){
        return ResponseEntity.ok(service.ottieniProdottoDettaglio(idProdotto));
    }

    @ApiOperation(value = "Inserisci un nuovo prodotto", response = ProdottoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK")}
    )
    @PostMapping(value = "/inserisciProdotto")
    public void inserisciProdotto(@RequestBody ProdottoDTO prodottoDTO, @RequestParam boolean isAmministratore){
        service.inserisciProdotto(prodottoDTO,isAmministratore);
    }

    @ApiOperation(value = "Modifica un  prodotto", response = ProdottoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK")}
    )
    @PutMapping(value = "/modificaProdotto")
    public ResponseEntity<ProdottoDTO> modificaProdotto(@RequestParam Long idProdotto, @RequestBody ProdottoDTO prodottoDTO, @RequestParam boolean isAmministrator){
        return ResponseEntity.ok(service.modificaProdotto(idProdotto, prodottoDTO, isAmministrator));
    }

    @ApiOperation(value = "Rimuovi un  prodotto", response = ProdottoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK")}
    )
    @DeleteMapping(value = "/rimuoviProdotto")
    public void rimuoviProdotto(@RequestParam Long idProdotto, @RequestParam boolean isAmministratore){
        service.rimuoviProdotto(idProdotto,isAmministratore);
    }

    @ApiOperation(value = "Recupera prodotto in base ai filtri inseriti", response = ProdottoDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK")}
    )
    @GetMapping(value = "/ricercaProdottiByFilter")
    public ResponseEntity<List<ProdottoDTO>> ricercaProdottiByFilter(Long id, String nome, String descrizione, String categoria, Float prezzo){
        return ResponseEntity.ok(service.ricercaProdottiByFilter(id,nome,descrizione,categoria,prezzo));
    }
}
