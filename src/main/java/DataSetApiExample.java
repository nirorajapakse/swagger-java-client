import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.DataSetApi;
import io.swagger.client.api.DealersApi;
import io.swagger.client.api.VehiclesApi;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;

public class DataSetApiExample {

	public static String EMPTY = "";

	public static void main(String[] args) {

		String datasetId = EMPTY;
		DealersApi dealersApi = new DealersApi();
		DataSetApi apiInstance = new DataSetApi();
		VehiclesApi vehiclesApi = new VehiclesApi();

		ArrayList<VehicleAnswer> vehicleAnswerList = new ArrayList<VehicleAnswer>();
		HashMap<Integer, DealerAnswer> dealerMap = new HashMap<Integer, DealerAnswer>();
		HashMap<Integer, ArrayList<VehicleAnswer>> dealerVehicleMap = new HashMap<Integer, ArrayList<VehicleAnswer>>();

		try {
			// Retrieves a datasetID
			DatasetIdResponse datasetIdResponse = apiInstance.dataSetGetDataSetId();
			datasetId = datasetIdResponse.getDatasetId();

			if (null != datasetId && !datasetId.isEmpty()) {

				Integer dealerId;
				Answer answer = new Answer();
				VehicleResponse vehicleResponse;
				DealersResponse dealersResponse;
				VehicleIdsResponse vehicleIdsResponse = vehiclesApi.vehiclesGetIds(datasetId);

				for (int vehicleid : vehicleIdsResponse.getVehicleIds()) {
					vehicleResponse = vehiclesApi.vehiclesGetVehicle(datasetId, vehicleid);
					dealerId = vehicleResponse.getDealerId();

					if (dealerVehicleMap.containsKey(dealerId)) {
						vehicleAnswerList = dealerVehicleMap.get(dealerId);
						vehicleAnswerList.add(vehicleResponse.getVehicleAnswer());
					} else {
						vehicleAnswerList = new ArrayList<VehicleAnswer>();
						vehicleAnswerList.add(vehicleResponse.getVehicleAnswer());
						dealerVehicleMap.put(dealerId, vehicleAnswerList);
					}
					
					if (!dealerMap.containsKey(dealerId)) {
						dealersResponse = dealersApi.dealersGetDealer(datasetId, dealerId);
						dealerMap.put(dealerId, dealersResponse.getDealerAnswer(vehicleAnswerList));
					} else {
						dealerMap.get(dealerId).setVehicles(vehicleAnswerList);
					}
				}
				
				Iterator<Entry<Integer, DealerAnswer>> it = dealerMap.entrySet().iterator();
			    while (it.hasNext()) {
			    	Entry<Integer, DealerAnswer> entry = it.next();
			        answer.addDealersItem(entry.getValue());
			        it.remove();
			    }

			    //Testing the result.
				//Answer answer = apiInstance.dataSetGetCheat(datasetId);
				System.out.println(answer);

				/**
				 * You will receive a response structure when you post to the answer endpoint
				 * that describes status and total elapsed time.
				 */
				AnswerResponse answerResponse = apiInstance.dataSetPostAnswer(datasetId, answer);
				System.out.println("--- Answer Response ---");
				System.out.println("Status: " + (answerResponse.isSuccess() ? "SUCCESS" : "ERROR"));
				System.out.println("Message: " + answerResponse.getMessage());
				System.out.println("Total Milliseconds: " + answerResponse.getTotalMilliseconds());
			}
		} catch (ApiException e) {
			System.err.println("Exception when calling DataSetApi#dataSetGetCheat");
			e.printStackTrace();
		}
	}
}
