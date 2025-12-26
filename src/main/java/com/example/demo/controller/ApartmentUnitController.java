@RestController
@RequestMapping("/apartment-units")
public class ApartmentUnitController {

    private final ApartmentUnitServiceImpl service;

    public ApartmentUnitController(ApartmentUnitServiceImpl service) {
        this.service = service;
    }
}
