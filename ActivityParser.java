public class ActivityParser {
  private static final ObjectMapper XML_MAPPER = new XmlMapper();
  private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

  static {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
    XML_MAPPER.setDateFormat(simpleDateFormat);
    JSON_MAPPER.setDateFormat(simpleDateFormat);
  }

  public static String serialize(Activity activity, Format format) {
    return format.equals(Format.JSON) ? serialize(activity, JSON_MAPPER) : serialize(activity, XML_MAPPER);
  }

  private static String serialize(Activity activity, ObjectMapper objectMapper) {
    try {
      return objectMapper.writeValueAsString(activity);
    } catch (IOException e) {
      throw new UncheckedIOException("Exception", e);
    }
  }
  
  public static Activy deserialize(String activity, Format format) {
    return format.equals(Format.JSON) ? deserialize(activity, JSON_MAPPER) : deserialize(activity, XML_MAPPER);
  }

  private static Activity deserialize(String activity, ObjectMapper objectMapper) {
    try {
      return objectMapper.readValue(activity, Activity.class);
    } catch (JsonProcessingException e) {
      throw new UncheckedIOException("Exception!", e);
    }
  }
}