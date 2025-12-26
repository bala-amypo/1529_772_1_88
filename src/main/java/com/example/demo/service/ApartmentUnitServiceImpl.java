@Service
public class ApartmentUnitServiceImpl {

    private final ApartmentUnitRepository repository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository repository) {
        this.repository = repository;
    }
}
