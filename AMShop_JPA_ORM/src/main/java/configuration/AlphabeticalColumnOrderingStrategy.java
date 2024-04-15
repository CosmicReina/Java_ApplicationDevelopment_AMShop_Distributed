package configuration;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.ColumnOrderingStrategyLegacy;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Table;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlphabeticalColumnOrderingStrategy extends ColumnOrderingStrategyLegacy
		implements
			HibernatePropertiesCustomizer {

	@Override
	public List<Column> orderTableColumns(Table table, Metadata metadata) {
		return table.getColumns().stream().sorted(Comparator.comparing(Column::getName)).toList();
	}

	@Override
	public void customize(Map<String, Object> hibernateProperties) {
		hibernateProperties.put(AvailableSettings.COLUMN_ORDERING_STRATEGY, this);
	}

}
