package com.xantrix.webapp.UnitTest.ControllerTest;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.xantrix.webapp.Application;


@ContextConfiguration(classes = Application.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SelectArticoloTest {
	private MockMvc mockMvc;

	private final String PROTOCOL = "http";
	private final String HOST = "localhost";
	private final String PORT  = "5051";
	@Autowired
	private WebApplicationContext webAppCtx;

	@BeforeEach
	public void init() {
		DefaultMockMvcBuilder webAppCtxSetup = MockMvcBuilders.webAppContextSetup(webAppCtx);
		this.mockMvc = webAppCtxSetup.build();
	}
	
	String JsonData =  
			"{\n" + 
			"    \"codArt\": \"002000301\",\n" + 
			"    \"descrizione\": \"ACQUA ULIVETO 15 LT\",\n" + 
			"    \"um\": \"PZ\",\n" + 
			"    \"codStat\": \"\",\n" + 
			"    \"pzCart\": 6,\n" + 
			"    \"pesoNetto\": 1.5,\n" + 
			"    \"idStatoArt\": \"1\",\n" + 
			"    \"dataCreaz\": \"2010-06-14\",\n" + 
			"    \"barcode\": [\n" + 
			"        {\n" + 
			"            \"barcode\": \"8008490000021\",\n" + 
			"            \"idTipoArt\": \"CP\"\n" + 
			"        }\n" + 
			"    ],\n" + 
			"    \"famAssort\": {\n" + 
			"        \"id\": 1,\n" + 
			"        \"descrizione\": \"DROGHERIA ALIMENTARE\"\n" + 
			"    },\n" + 
			"    \"ingredienti\": null,\n" + 
			"    \"iva\": {\n" + 
			"        \"idIva\": 22,\n" + 
			"        \"descrizione\": \"IVA RIVENDITA 22%\",\n" + 
			"        \"aliquota\": 22\n" + 
			"    }\n" + 
			"}";
	
	/*
	 * 
	 */
	@Test
	@Order(1)
	public void testGetArticoliByBarcode() throws Exception {
		final String theBarcode = "8008490000021";
		
		mockMvc.perform(MockMvcRequestBuilders.get(PROTOCOL + "://" + HOST + ":" + PORT + "/api/articolo/barcode/" + theBarcode)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				 
				//articoli
				.andExpect(jsonPath("$.payload.codiceArticolo").exists())
				.andExpect(jsonPath("$.payload.codiceArticolo").value("002000301"))
				.andExpect(jsonPath("$.payload.descrizioneArticolo").exists())
				.andExpect(jsonPath("$.payload.descrizioneArticolo").value("ACQUA ULIVETO 15 LT"))
				.andExpect(jsonPath("$.payload.um").exists())
				.andExpect(jsonPath("$.payload.um").value("PZ"))
				.andExpect(jsonPath("$.payload.codiceStatisticoArticolo").exists())
				.andExpect(jsonPath("$.payload.codiceStatisticoArticolo").value(""))
				.andExpect(jsonPath("$.payload.pzCart").exists())
				.andExpect(jsonPath("$.payload.pzCart").value("6"))
				.andExpect(jsonPath("$.payload.pesoNettoArticolo").exists())
				.andExpect(jsonPath("$.payload.pesoNettoArticolo").value("1.5"))
				.andExpect(jsonPath("$.payload.idStatoArticolo").exists())
				.andExpect(jsonPath("$.payload.idStatoArticolo").value("1"))
				.andExpect(jsonPath("$.payload.dataCreazioneArticolo").exists())
				.andExpect(jsonPath("$.payload.dataCreazioneArticolo").value("2010-06-14"))
				 //barcode             
				.andExpect(jsonPath("$.payload.codiciABarreArticolo[0].barcodeString").exists())
				.andExpect(jsonPath("$.payload.codiciABarreArticolo[0].barcodeString").value("8008490000021")) 
				.andExpect(jsonPath("$.payload.codiciABarreArticolo[0].idTipoArticolo").exists())
				.andExpect(jsonPath("$.payload.codiciABarreArticolo[0].idTipoArticolo").value("CP")) 
				 //famAssort           
				.andExpect(jsonPath("$.payload.famigliaAssortimento.codice").exists())
				.andExpect(jsonPath("$.payload.famigliaAssortimento.codice").value("1")) 
				.andExpect(jsonPath("$.payload.famigliaAssortimento.descrizione").exists())
				.andExpect(jsonPath("$.payload.famigliaAssortimento.descrizione").value("DROGHERIA ALIMENTARE")) 
				 //ingredienti         
				.andExpect(jsonPath("$.payload.ingredienteArticolo").isEmpty())
				 //Iva                 
				.andExpect(jsonPath("$.payload.ivaArticolo.codice").exists())
				.andExpect(jsonPath("$.payload.ivaArticolo.codice").value("22")) 
				.andExpect(jsonPath("$.payload.ivaArticolo.descrizione").exists())
				.andExpect(jsonPath("$.payload.ivaArticolo.descrizione").value("IVA RIVENDITA 22%"))
				.andExpect(jsonPath("$.payload.ivaArticolo.aliquota").exists())
				.andExpect(jsonPath("$.payload.ivaArticolo.aliquota").value("22"))	
				
				.andDo(print());
	}
	
	
	@Test
	@Order(2)
	public void testGetArticolyByBarcode_KO() throws Exception {
		final String theBarcode = "8008490002138";

		mockMvc.perform(MockMvcRequestBuilders.get(PROTOCOL + "://" + HOST + ":" + PORT + "api/articolo/barcode/" + theBarcode)
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonData)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.codice").value(404))
				.andExpect(jsonPath("$.messaggio").value("Il barcode " + theBarcode + " non è stato trovato!"))
				.andDo(print());
	}
	
	@Test
	@Order(3)
	public void testGetArticolyByCodArt() throws Exception {
		final String theCodArt = "002000301";
		
		mockMvc.perform(MockMvcRequestBuilders.get(PROTOCOL + "://" + HOST + ":" + PORT + "api/articolo/" + theCodArt)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(content().json(JsonData)) 
				.andReturn();
	}
	
	
	@Test
	@Order(4)
	public void testArticolyByCodArt_KO() throws Exception {
		final String theCodArt = "002000301b";

		mockMvc.perform(MockMvcRequestBuilders.get(PROTOCOL + "://" + HOST + ":" + PORT + "api/articolo/" + theCodArt)
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonData)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.codice").value(404))
				.andExpect(jsonPath("$.messaggio").value("L'articolo con codice " + theCodArt + " non è stato trovato!"))
				.andDo(print());
	}
	
	private String JsonData2 = "[" + JsonData + "]";

	@Test
	@Order(5)
	public void testGetArticoliByDescrizione() throws Exception {
		final String theDescrizioneFilter = "ACQUA ULIVETO 15 LT";

		mockMvc.perform(MockMvcRequestBuilders.get(PROTOCOL + "://" + HOST + ":" + PORT + "api/articolo?descrizione=" + theDescrizioneFilter)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				//.andExpect(content().json(JsonData2)) 
				.andReturn();
	}
	
	@Test
	@Order(6)
	public void testGetArticoliByDescrizione_KO() throws Exception {
		final String theDescrizioneFilter = "123ABC";
		
		mockMvc.perform(MockMvcRequestBuilders.get(PROTOCOL + "://" + HOST + ":" + PORT + "api/articolo?descrizione=" + theDescrizioneFilter)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.codice").value(404))
				.andExpect(jsonPath("$.messaggio").value("Non è stato trovato alcun articolo avente descrizione " + theDescrizioneFilter))
				.andReturn();
	}
}
