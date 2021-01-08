public class Main {
  private static final Logger LOG = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    Activity1 activity1 = Activity.ActivityBuilder.anActivity()
    .withUserName("Williamson")
	.withWebsiteName("xyz.com")
	.withActivityTypeCode(001)
    .withLoggedInTime(new Date())
	.withNumberOfViews(10)
    .withActivity2(List.of(new Activity2("Sam", "abc.com","Viewed","01/13/2020")))
    .build();

    String xmlActivity = ArticleParser.serialize(article, Format.XML);
    String jsonActivity = ArticleParser.serialize(article, Format.JSON);

    LOG.info(xmlActivity);
    LOG.info(jsonActivity);
  }
}