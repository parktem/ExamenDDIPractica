package es.salesianos.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Owner;
import es.salesianos.model.Pet;

@org.springframework.stereotype.Repository
public class OwnerRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Owner search(int codOwner) {
		Owner owner = new Owner();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM OWNER WHERE codOwner = ?");
			prepareStatement.setInt(1, codOwner);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				owner = new Owner();
				owner.setCodOwner(resultSet.getInt(1));
				owner.setName(resultSet.getString(2));
				owner.setSurname(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return owner;
	}

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void insert(Owner ownerFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO OWNER (name,surname)" + "VALUES (?, ?)");
			preparedStatement.setString(1, ownerFormulario.getName());
			preparedStatement.setString(2, ownerFormulario.getSurname());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void update(Owner ownerFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE OWNER SET name = (?), surname = (?) WHERE codOwner = (?)");
			preparedStatement.setString(1, ownerFormulario.getName());
			preparedStatement.setString(2, ownerFormulario.getSurname());
			preparedStatement.setInt(3, ownerFormulario.getCodOwner());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void delete(Integer codOwner) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM PET WHERE codOwner = (?)");
			preparedStatement.setInt(1, codOwner);
			preparedStatement.executeUpdate();
			preparedStatement = conn.prepareStatement("DELETE FROM OWNER WHERE codOwner = (?)");
			preparedStatement.setInt(1, codOwner);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public List<Owner> selectAllOwners() {
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		List<Owner> ownerList = new ArrayList<Owner>();
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM OWNER");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				List<Pet> pets = new ArrayList<Pet>();
				Owner ownerFromDatabase = new Owner();
				ownerFromDatabase.setCodOwner(resultSet.getInt(1));
				ownerFromDatabase.setName(resultSet.getString(2));
				ownerFromDatabase.setSurname(resultSet.getString(3));
				ownerList.add(ownerFromDatabase);
			}
			int index = 0;
			for (Owner owner : ownerList) {
				prepareStatement = conn.prepareStatement("SELECT * FROM PET where codOwner=" + owner.getCodOwner());
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Pet pet = new Pet();
					pet.setName(resultSet.getString(1));
					pet.setCodOwner(resultSet.getInt(2));
					owner.getPets().add(pet);
				}
				ownerList.set(index, owner);
				index++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return ownerList;
	}

}
