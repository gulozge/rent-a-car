package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import kodlama.io.rentacar.entities.Maintenance;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository ;
    private CarService carService;
    private final ModelMapper mapper;
    @Override
    public List<GetAllMaintenanceResponse> getAll() {
        List<Maintenance> maintenances = repository.findAll();
        List<GetAllMaintenanceResponse> response = maintenances
                .stream()
                .map(maintenance -> mapper.map(maintenance,GetAllMaintenanceResponse.class))
                .toList();
        return response;

    }
    @Override
    public GetMaintenanceResponse getById(int id) {
        Maintenance maintenanace=repository.findById(id).orElseThrow();
        GetMaintenanceResponse response=mapper.map(maintenanace, GetMaintenanceResponse.class);
        return response;
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {

        Maintenance maintenanace=mapper.map(request, Maintenance.class);
        maintenanace.setId(0);

        int carId=request.getCarId();

        checkIfCarCanBeSentToMaintenance(carId);
        changeCarStatus(carId,State.MAINTANCE);
        repository.save(maintenanace);

        CreateMaintenanceResponse response=mapper.map(maintenanace,CreateMaintenanceResponse.class);
        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        checkIfMaintenanceExist(id);

        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(id);

        int carId=request.getCarId();
        if(!maintenance.isCaseMaintenance()){
            changeCarStatus(carId, State.AVAILABLE);
        }else{
            changeCarStatus(carId, State.MAINTANCE);
        }
       UpdateMaintenanceResponse response= mapper.map(repository.save(maintenance), UpdateMaintenanceResponse.class);
        return response;

    }

    @Override
    public void delete(int carId) {
        checkIfMaintenanceExist(carId);
        changeCarStatus(carId,State.AVAILABLE);
    }

    private void checkIfMaintenanceExist(int id) {
        if (!repository.existsById(id)) throw new RuntimeException("Maintenance Id does not exist!");
    }

    private void checkIfCarCanBeSentToMaintenance(int carId){
        GetCarResponse car = carService.getById(carId);
        if(car.getState() == State.MAINTANCE) {
            throw new RuntimeException("Car is maintenance!");
        }
        else if(car.getState() == State.RENTED)  throw new RuntimeException("Car is rented!") ;
    }

    private void changeCarStatus(int carId,State state){
        GetCarResponse car = carService.getById(carId);
        car.setState(state);
        UpdateCarRequest carUpdate = mapper.map(car, UpdateCarRequest.class);
        carService.update(carId,carUpdate);
    }
}
