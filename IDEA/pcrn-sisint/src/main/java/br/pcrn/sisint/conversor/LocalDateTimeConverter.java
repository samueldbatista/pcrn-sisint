package br.pcrn.sisint.conversor;



import static com.google.common.base.Strings.isNullOrEmpty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;

/**
 * A converter for {@link LocalDateTime}.
 *
 * @author Lucas Cavalcanti
 * @author Otávio Scherer Garcia
 */
@Convert(LocalDateTime.class)
@RequestScoped
public class LocalDateTimeConverter implements Converter<LocalDateTime> {

    private final Locale locale;

    /**
     * @deprecated CDI eyes only
     */
    protected LocalDateTimeConverter() {
        this(null);
    }

    @Inject
    public LocalDateTimeConverter(Locale locale) {
        this.locale = locale;
    }

    @Override
    public LocalDateTime convert(String value, Class<? extends LocalDateTime> type) {
        if (isNullOrEmpty(value)) {
            return null;
        }

        try {
            return LocalDateTime.parse(value, getFormatter());
        } catch (DateTimeParseException e) {
            throw new ConversionException(new ConversionMessage("is_not_a_valid_datetime", value));
        }
    }

    protected DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(locale);
    }
}