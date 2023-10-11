package com.nicolas.parcial.controladores;

import com.nicolas.parcial.entidades.Domicilio;
import com.nicolas.parcial.servicios.DomicilioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/basedatos/domicilios")
public class DomicilioController extends BaseControllerImpl <Domicilio, DomicilioServiceImpl>{

}
