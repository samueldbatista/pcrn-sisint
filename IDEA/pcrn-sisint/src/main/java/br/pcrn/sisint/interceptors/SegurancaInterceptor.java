package br.pcrn.sisint.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.pcrn.sisint.controller.LoginController;

import javax.inject.Inject;

//@Intercepts
public class SegurancaInterceptor {

//    private final Result resultado;
//
//    @Inject
//    public SegurancaInterceptor(Result resultado) {
//        this.resultado = resultado;
//    }
//
//    @AroundCall
//    public boolean verificarSegurança(ControllerMethod method){
//        if(usuario.isLogado()){
//            stack.next();
//        } else {
//            resultado.redirectTo(LoginController.class).form();
//        }
//    }
//
//    private boolean verificarPermissao{
//        return method
//    }
}
