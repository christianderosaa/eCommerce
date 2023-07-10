package it.reactive.eCommerce.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.reactive.eCommerce.dto.ProdottoDTO;
import it.reactive.eCommerce.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ProdottoDTO> ottieniProdottoDettaglio(Long idProdotto){
        return ResponseEntity.ok(service.ottieniProdottoDettaglio(idProdotto));
    }

}
