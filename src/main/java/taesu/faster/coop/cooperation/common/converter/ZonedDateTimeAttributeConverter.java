package taesu.faster.coop.cooperation.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * @author Lee Tae Su 
 * @project cooperation
 * @version 1.0
 * @since 2018-02-07
 */
@Converter(autoApply = true)
public class ZonedDateTimeAttributeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {
	
	@Override
	public Timestamp convertToDatabaseColumn(ZonedDateTime zonedDateTime) {
		return (zonedDateTime == null ? null : Timestamp.valueOf(zonedDateTime.toLocalDateTime()));
	}
	
	@Override
	public ZonedDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
		return (sqlTimestamp == null ? null : ZonedDateTime.of(sqlTimestamp.toLocalDateTime(), ZoneOffset.UTC));
	}
}