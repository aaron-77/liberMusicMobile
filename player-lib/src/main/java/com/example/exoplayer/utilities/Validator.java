package com.example.exoplayer.utilities;

import java.util.regex.Pattern;

public class Validator {
    public static final String REGEX_URL_IMAGEN ="^((http)|(https)):\\/\\/(\\w+\\/){3}[a-zA-Z-0-9\\-]{36,200}\\/(\\w+\\/)[a-zA-Z-0-9\\-]{36,200}\\/(\\w+\\/)(\\w+(.jpg|.png))$";
    public static final String REGEX_URL_CANCION="^^((http)|(https)):\\/\\/(\\w+\\/){3}[a-zA-Z-0-9\\-]{36,200}\\/(\\w+\\/)[a-zA-Z-0-9\\-]{36,200}\\/(\\w+\\/)[a-zA-Z-0-9\\-]{36,200}\\/(\\w+(.mpd))$";

    public static boolean validarTexto(String url,String patron){
        Pattern urlPattern = Pattern.compile(patron);
        return url != null & urlPattern.matcher(url).matches();
    }

    public static boolean validarValorNumericoEntero(int numeroParaValidar){
       return numeroParaValidar > 0;
    }


}
