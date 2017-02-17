package servlets;

import java.io.IOException;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class HibernateProxyTypeAdapter extends TypeAdapter<HibernateProxy> {

	public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
		@SuppressWarnings("unchecked")
		public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
			return (HibernateProxy.class.isAssignableFrom(type.getRawType())
					? (TypeAdapter<T>) new HibernateProxyTypeAdapter(
							(TypeAdapter) gson.getAdapter(TypeToken.get(type.getRawType().getSuperclass())))
					: null);
		}
	};
	private final TypeAdapter<Object> delegate;

	private HibernateProxyTypeAdapter(TypeAdapter<Object> delegate) {
		this.delegate = delegate;
	}

	@Override
	public HibernateProxy read(JsonReader in) throws IOException {
		throw new UnsupportedOperationException("Not supported");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void write(JsonWriter out, HibernateProxy value) throws IOException {
		if (value == null) {
			out.nullValue();
			return;
		}
		delegate.write(out, ((HibernateProxy) value).getHibernateLazyInitializer().getImplementation());
	}
}
