package com.app.cristian.rerumbeta.modelos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by nicolaspickelny on 5/13/17.
 */

@Root(name = "Item")
public class Item
{
    @Element(name = "Imagen", required = false)
    private String Imagen;

    @Element(name = "Calificacion", required = false)
    private String Calificacion;

    @Element(name = "MarcaProximosEventos", required = false)
    private String MarcaProximosEventos;

    @Element(name = "Resumen", required = false)
    private String Resumen;

    @Element(name = "FechaPublicacionHasta", required = false)
    private String FechaPublicacionHasta;

    @Element(name = "DestacadoHome", required = false)
    private String DestacadoHome;

    @Element(name = "IdEvento", required = false)
    private String IdEvento;

    @Element(name = "IdEventosRelacionados", required = false)
    private String IdEventosRelacionados;

    @Element(name = "IdEstadoEvento", required = false)
    private String IdEstadoEvento;

    @Element(name = "FechaFin", required = false)
    private String FechaFin;

    @Element(name = "Hora", required = false)
    private String Hora;

    @Element(name = "FechaProximoEventoHasta", required = false)
    private String FechaProximoEventoHasta;

    @Element(name = "FechaInicio", required = false)
    private String FechaInicio;

    @Element(name = "Minutos", required = false)
    private String Minutos;

    @Element(name = "IdTipoEvento", required = false)
    private String IdTipoEvento;

    @Element(name = "Lugares", required = false)
    private String Lugares;

    @Element(name = "FechaProximoEventoDesde", required = false)
    private String FechaProximoEventoDesde;

    @Element(name = "Facebook", required = false)
    private String Facebook;

    @Element(name = "YoutubeFeaturedVideo", required = false)
    private String YoutubeFeaturedVideo;

    @Element(name = "Descripcion", required = false)
    private String Descripcion;

    @Element(name = "AlbumFlickr", required = false)
    private String AlbumFlickr;

    @Element(name = "DestacadoBoxPrimario", required = false)
    private String DestacadoBoxPrimario;

    @Element(name = "DestacadoListados", required = false)
    private String DestacadoListados;

    @Element(name = "Titulo", required = false)
    private String Titulo;

    @Element(name = "IdCategorias", required = false)
    private String IdCategorias;

    @Element(name = "IdEventoPadre", required = false)
    private String IdEventoPadre;

    @Element(name = "Youtube", required = false)
    private String Youtube;

    @Element(name = "Twitter", required = false)
    private String Twitter;

    @Element(name = "FechaPublicacionDesde", required = false)
    private String FechaPublicacionDesde;

    public String getImagen ()
    {
        return Imagen;
    }

    public void setImagen (String Imagen)
    {
        this.Imagen = Imagen;
    }

    public String getCalificacion ()
    {
        return Calificacion;
    }

    public void setCalificacion (String Calificacion)
    {
        this.Calificacion = Calificacion;
    }

    public String getMarcaProximosEventos ()
    {
        return MarcaProximosEventos;
    }

    public void setMarcaProximosEventos (String MarcaProximosEventos)
    {
        this.MarcaProximosEventos = MarcaProximosEventos;
    }

    public String getResumen ()
    {
        return Resumen;
    }

    public void setResumen (String Resumen)
    {
        this.Resumen = Resumen;
    }

    public String getFechaPublicacionHasta ()
    {
        return FechaPublicacionHasta;
    }

    public void setFechaPublicacionHasta (String FechaPublicacionHasta)
    {
        this.FechaPublicacionHasta = FechaPublicacionHasta;
    }

    public String getDestacadoHome ()
    {
        return DestacadoHome;
    }

    public void setDestacadoHome (String DestacadoHome)
    {
        this.DestacadoHome = DestacadoHome;
    }

    public String getIdEvento ()
    {
        return IdEvento;
    }

    public void setIdEvento (String IdEvento)
    {
        this.IdEvento = IdEvento;
    }

    public String getIdEventosRelacionados ()
    {
        return IdEventosRelacionados;
    }

    public void setIdEventosRelacionados (String IdEventosRelacionados)
    {
        this.IdEventosRelacionados = IdEventosRelacionados;
    }

    public String getIdEstadoEvento ()
    {
        return IdEstadoEvento;
    }

    public void setIdEstadoEvento (String IdEstadoEvento)
    {
        this.IdEstadoEvento = IdEstadoEvento;
    }

    public String getFechaFin ()
    {
        return FechaFin;
    }

    public void setFechaFin (String FechaFin)
    {
        this.FechaFin = FechaFin;
    }

    public String getHora ()
    {
        return Hora;
    }

    public void setHora (String Hora)
    {
        this.Hora = Hora;
    }

    public String getFechaProximoEventoHasta ()
    {
        return FechaProximoEventoHasta;
    }

    public void setFechaProximoEventoHasta (String FechaProximoEventoHasta)
    {
        this.FechaProximoEventoHasta = FechaProximoEventoHasta;
    }

    public String getFechaInicio ()
    {
        return FechaInicio;
    }

    public void setFechaInicio (String FechaInicio)
    {
        this.FechaInicio = FechaInicio;
    }

    public String getMinutos ()
    {
        return Minutos;
    }

    public void setMinutos (String Minutos)
    {
        this.Minutos = Minutos;
    }

    public String getIdTipoEvento ()
    {
        return IdTipoEvento;
    }

    public void setIdTipoEvento (String IdTipoEvento)
    {
        this.IdTipoEvento = IdTipoEvento;
    }

    public String getLugares ()
    {
        return Lugares;
    }

    public void setLugares (String Lugares)
    {
        this.Lugares = Lugares;
    }

    public String getFechaProximoEventoDesde ()
    {
        return FechaProximoEventoDesde;
    }

    public void setFechaProximoEventoDesde (String FechaProximoEventoDesde)
    {
        this.FechaProximoEventoDesde = FechaProximoEventoDesde;
    }

    public String getFacebook ()
    {
        return Facebook;
    }

    public void setFacebook (String Facebook)
    {
        this.Facebook = Facebook;
    }

    public String getYoutubeFeaturedVideo ()
    {
        return YoutubeFeaturedVideo;
    }

    public void setYoutubeFeaturedVideo (String YoutubeFeaturedVideo)
    {
        this.YoutubeFeaturedVideo = YoutubeFeaturedVideo;
    }

    public String getDescripcion ()
    {
        return Descripcion;
    }

    public void setDescripcion (String Descripcion)
    {
        this.Descripcion = Descripcion;
    }

    public String getAlbumFlickr ()
    {
        return AlbumFlickr;
    }

    public void setAlbumFlickr (String AlbumFlickr)
    {
        this.AlbumFlickr = AlbumFlickr;
    }

    public String getDestacadoBoxPrimario ()
    {
        return DestacadoBoxPrimario;
    }

    public void setDestacadoBoxPrimario (String DestacadoBoxPrimario)
    {
        this.DestacadoBoxPrimario = DestacadoBoxPrimario;
    }

    public String getDestacadoListados ()
    {
        return DestacadoListados;
    }

    public void setDestacadoListados (String DestacadoListados)
    {
        this.DestacadoListados = DestacadoListados;
    }

    public String getTitulo ()
    {
        return Titulo;
    }

    public void setTitulo (String Titulo)
    {
        this.Titulo = Titulo;
    }

    public String getIdCategorias ()
    {
        return IdCategorias;
    }

    public void setIdCategorias (String IdCategorias)
    {
        this.IdCategorias = IdCategorias;
    }

    public String getIdEventoPadre ()
    {
        return IdEventoPadre;
    }

    public void setIdEventoPadre (String IdEventoPadre)
    {
        this.IdEventoPadre = IdEventoPadre;
    }

    public String getYoutube ()
    {
        return Youtube;
    }

    public void setYoutube (String Youtube)
    {
        this.Youtube = Youtube;
    }

    public String getTwitter ()
    {
        return Twitter;
    }

    public void setTwitter (String Twitter)
    {
        this.Twitter = Twitter;
    }

    public String getFechaPublicacionDesde ()
    {
        return FechaPublicacionDesde;
    }

    public void setFechaPublicacionDesde (String FechaPublicacionDesde)
    {
        this.FechaPublicacionDesde = FechaPublicacionDesde;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Imagen = "+Imagen+", Calificacion = "+Calificacion+", MarcaProximosEventos = "+MarcaProximosEventos+", Resumen = "+Resumen+", FechaPublicacionHasta = "+FechaPublicacionHasta+", DestacadoHome = "+DestacadoHome+", IdEvento = "+IdEvento+", IdEventosRelacionados = "+IdEventosRelacionados+", IdEstadoEvento = "+IdEstadoEvento+", FechaFin = "+FechaFin+", Hora = "+Hora+", FechaProximoEventoHasta = "+FechaProximoEventoHasta+", FechaInicio = "+FechaInicio+", Minutos = "+Minutos+", IdTipoEvento = "+IdTipoEvento+", Lugares = "+Lugares+", FechaProximoEventoDesde = "+FechaProximoEventoDesde+", Facebook = "+Facebook+", YoutubeFeaturedVideo = "+YoutubeFeaturedVideo+", Descripcion = "+Descripcion+", AlbumFlickr = "+AlbumFlickr+", DestacadoBoxPrimario = "+DestacadoBoxPrimario+", DestacadoListados = "+DestacadoListados+", Titulo = "+Titulo+", IdCategorias = "+IdCategorias+", IdEventoPadre = "+IdEventoPadre+", Youtube = "+Youtube+", Twitter = "+Twitter+", FechaPublicacionDesde = "+FechaPublicacionDesde+"]";
    }
}